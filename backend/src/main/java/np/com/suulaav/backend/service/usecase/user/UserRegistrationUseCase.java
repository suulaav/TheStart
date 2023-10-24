package np.com.suulaav.backend.service.usecase.user;

import np.com.suulaav.backend.core.service.api.UseCase;
import np.com.suulaav.backend.core.utils.SecurityUtils;
import np.com.suulaav.backend.core.utils.StringUtils;
import np.com.suulaav.backend.reposotary.api.user.UserDao;
import np.com.suulaav.backend.reposotary.converter.user.UserConverter;
import np.com.suulaav.backend.service.domain.user.UserDomain;

import java.time.LocalDateTime;

/**
 * @author Sulav created on 10/24/23
 */
public class UserRegistrationUseCase implements UseCase<UserDomain, String> {
  private final UserDao userDao;

  public UserRegistrationUseCase(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public String execute(UserDomain request) {
    this.validate(request);
    request.setId(StringUtils.generateUUID());
    request.setCreatedBy("SYSTEM");
    request.setCreatedOn(LocalDateTime.now().toString());
    request.setPassword(SecurityUtils.oneWayEncoding(request.getPassword()));
    request.setActive(true);
    this.userDao.insert(new UserConverter().toEntity(request));
    return request.getId();
  }

  @Override
  public void validate(UserDomain request) {}
}
