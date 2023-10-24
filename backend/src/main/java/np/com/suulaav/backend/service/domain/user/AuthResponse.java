package np.com.suulaav.backend.service.domain.user;

import lombok.Data;

/**
 * @author Sulav created on 10/23/23
 */
@Data
public class AuthResponse {
    private String token;
    private String userName;
    private String id;
}
