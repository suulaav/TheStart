package np.com.suulaav.backend.service.impl.user.auth;

import java.util.Collections;
import java.util.Optional;
import np.com.suulaav.backend.reposotary.api.user.UserDao;
import np.com.suulaav.backend.security.context.ApplicationContext;
import np.com.suulaav.backend.security.context.ApplicationRequestContextHolder;
import np.com.suulaav.backend.security.jwt.JwtHelper;
import np.com.suulaav.backend.service.api.user.auth.AuthService;
import np.com.suulaav.backend.service.domain.user.AuthRequest;
import np.com.suulaav.backend.service.domain.user.AuthResponse;
import np.com.suulaav.backend.service.domain.user.UserDomain;
import np.com.suulaav.backend.service.filter.user.DefaultUserFilter;
import np.com.suulaav.backend.service.usecase.user.auth.UserAuthUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Sulav created on 10/24/23
 */
@Component
public class AuthServiceImpl implements AuthService {

  private final UserDao userDao;

  @Autowired
  public AuthServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public AuthResponse authenticate(AuthRequest authRequest) {
    return new UserAuthUseCase(this.userDao).execute(authRequest);
  }
}
