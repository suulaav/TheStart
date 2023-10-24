package np.com.suulaav.backend.service.domain.user;

import lombok.Data;
import np.com.suulaav.backend.core.service.domain.AbstractDomain;

/**
 * @author Sulav created on 10/23/23
 */
@Data
public class UserDomain extends AbstractDomain {
  private String id;
  private String userName;
  private String password;
}
