package np.com.suulaav.backend.service.api.user.auth;

import np.com.suulaav.backend.core.service.api.Service;
import np.com.suulaav.backend.service.domain.user.AuthRequest;
import np.com.suulaav.backend.service.domain.user.AuthResponse;

/**
 * @author Sulav created on 10/24/23
 */
public interface AuthService extends Service {
  AuthResponse authenticate(AuthRequest authRequest);
}
