package np.com.suulaav.backend.core.service.api;

import np.com.suulaav.backend.service.domain.user.AuthRequest;

/**
 * @author Sulav created on 10/24/23
 */
public interface UseCase<Re, Rp> {
  Rp execute(Re request);

    void validate(Re request);
}
