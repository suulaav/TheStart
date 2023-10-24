package np.com.suulaav.backend.service.usecase.user.auth;

import np.com.suulaav.backend.core.service.api.UseCase;
import np.com.suulaav.backend.core.utils.SecurityUtils;
import np.com.suulaav.backend.core.utils.StringUtils;
import np.com.suulaav.backend.reposotary.api.user.UserDao;
import np.com.suulaav.backend.security.jwt.JwtHelper;
import np.com.suulaav.backend.service.domain.user.AuthRequest;
import np.com.suulaav.backend.service.domain.user.AuthResponse;
import np.com.suulaav.backend.service.domain.user.UserDomain;
import np.com.suulaav.backend.service.filter.user.DefaultUserFilter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Sulav created on 10/24/23
 */
public class UserAuthUseCase implements UseCase<AuthRequest, AuthResponse> {
  private final UserDao userDao;

  public UserAuthUseCase(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public AuthResponse execute(AuthRequest request) {
    this.validate(request);
    UserDomain userDomain = this.getUser(request);
    this.prepareAuthResponse(userDomain);
    return this.prepareAuthResponse(userDomain);
  }

  private AuthResponse prepareAuthResponse(UserDomain userDomain) {
    AuthResponse authResponse = new AuthResponse();
    authResponse.setUserName(userDomain.getUserName());
    authResponse.setId(userDomain.getId());
    // TODO change clams to remove literals
    Map<String, Object> clams = new HashMap<>();
    clams.put("subject", userDomain.getId());
    clams.put("userName", userDomain.getUserName());
    authResponse.setToken(JwtHelper.generate(clams));
    return authResponse;
  }

  private UserDomain getUser(AuthRequest request) {
    DefaultUserFilter defaultUserFilter = new DefaultUserFilter();
    defaultUserFilter.setUserName(request.getUserName());
    UserDomain userDomain =
        this.userDao
            .findOneByUserName(defaultUserFilter)
            .orElseThrow(() -> new RuntimeException("user not found"));
    if (!SecurityUtils.oneWayEncoding(request.getPassword())
        .equalsIgnoreCase(userDomain.getPassword())) {
      // TODO Proper exception handling
      throw new RuntimeException("invalid password");
    }
    return userDomain;
  }

  @Override
  public void validate(AuthRequest request) {
    // TODO Proper exception handling

    if (StringUtils.isNullOrBlank(request.getUserName())) {
      throw new RuntimeException("username empty");
    }
    if (StringUtils.isNullOrBlank(request.getPassword())) {
      throw new RuntimeException("password empty");
    }
  }
}
