package np.com.suulaav.backend.service.domain.user;

import lombok.Data;

/**
 * @author Sulav created on 10/23/23
 */
@Data
public class UserAuthRequest {
  private String userName;
  private String password;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
