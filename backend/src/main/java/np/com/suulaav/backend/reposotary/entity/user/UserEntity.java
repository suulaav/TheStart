package np.com.suulaav.backend.reposotary.entity.user;

import lombok.Data;
import np.com.suulaav.backend.core.repository.entity.AbstractEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Sulav created on 10/23/23
 */
@Data
@Document("users")
public class UserEntity extends AbstractEntity {
  @Id private String id;
  private String userName;
  private String password;
}
