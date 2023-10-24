package np.com.suulaav.backend.service.usecase.user;

import np.com.suulaav.backend.core.service.api.UseCase;
import np.com.suulaav.backend.core.utils.SecurityUtils;
import np.com.suulaav.backend.core.utils.StringUtils;
import np.com.suulaav.backend.reposotary.api.user.UserDao;
import np.com.suulaav.backend.security.jwt.JwtHelper;
import np.com.suulaav.backend.service.domain.user.UserAuthRequest;
import np.com.suulaav.backend.service.domain.user.UserAuthResponse;
import np.com.suulaav.backend.service.domain.user.UserDomain;
import np.com.suulaav.backend.service.filter.user.DefaultUserFilter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sulav created on 10/24/23
 */
public class UserAuthUseCase implements UseCase<UserAuthRequest, UserAuthResponse> {
  private final UserDao userDao;

  public UserAuthUseCase(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public UserAuthResponse execute(UserAuthRequest request) {
    this.validate(request);
    UserDomain userDomain = this.getUser(request);
    this.prepareAuthResponse(userDomain);
    return this.prepareAuthResponse(userDomain);
  }

  private UserAuthResponse prepareAuthResponse(UserDomain userDomain) {
    UserAuthResponse userAuthResponse = new UserAuthResponse();
    userAuthResponse.setUserName(userDomain.getUserName());
    userAuthResponse.setId(userDomain.getId());
    // TODO change clams to remove literals
    Map<String, Object> clams = new HashMap<>();
    clams.put("subject", userDomain.getId());
    clams.put("userName", userDomain.getUserName());
    userAuthResponse.setToken(JwtHelper.generate(clams));
    return userAuthResponse;
  }

  private UserDomain getUser(UserAuthRequest request) {
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
  public void validate(UserAuthRequest request) {
    // TODO Proper exception handling

    if (StringUtils.isNullOrBlank(request.getUserName())) {
      throw new RuntimeException("username empty");
    }
    if (StringUtils.isNullOrBlank(request.getPassword())) {
      throw new RuntimeException("password empty");
    }
  }
}
