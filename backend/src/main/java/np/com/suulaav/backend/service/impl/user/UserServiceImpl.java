package np.com.suulaav.backend.service.impl.user;

import np.com.suulaav.backend.reposotary.api.user.UserDao;
import np.com.suulaav.backend.service.api.user.UserService;
import np.com.suulaav.backend.service.domain.user.UserAuthRequest;
import np.com.suulaav.backend.service.domain.user.UserAuthResponse;
import np.com.suulaav.backend.service.domain.user.UserDomain;
import np.com.suulaav.backend.service.usecase.user.UserAuthUseCase;
import np.com.suulaav.backend.service.usecase.user.UserRegistrationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Sulav created on 10/24/23
 */
@Component
public class UserServiceImpl implements UserService {

  private final UserDao userDao;

  @Autowired
  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public UserAuthResponse authenticate(UserAuthRequest userAuthRequest) {
    return new UserAuthUseCase(this.userDao).execute(userAuthRequest);
  }

  @Override
  public String register(UserDomain userDomain) {
    return new UserRegistrationUseCase(this.userDao).execute(userDomain);
  }
}
