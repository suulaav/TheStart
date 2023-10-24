package np.com.suulaav.backend.security.context;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Sulav created on 10/24/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationContext {
  private String userName;
  private String Subject;
}
