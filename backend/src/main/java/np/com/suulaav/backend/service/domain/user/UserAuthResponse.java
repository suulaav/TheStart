package np.com.suulaav.backend.service.domain.user;

import lombok.Data;

/**
 * @author Sulav created on 10/23/23
 */
@Data
public class UserAuthResponse {
    private String id;
    private String userName;
    private String token;
}
