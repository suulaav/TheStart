package np.com.suulaav.backend.service.api.user;

import np.com.suulaav.backend.core.service.api.Service;
import np.com.suulaav.backend.service.domain.user.UserAuthRequest;
import np.com.suulaav.backend.service.domain.user.UserAuthResponse;
import np.com.suulaav.backend.service.domain.user.UserDomain;

/**
 * @author Sulav created on 10/24/23
 */
public interface UserService extends Service {
  UserAuthResponse authenticate(UserAuthRequest userAuthRequest);

  String register(UserDomain userDomain);
}
