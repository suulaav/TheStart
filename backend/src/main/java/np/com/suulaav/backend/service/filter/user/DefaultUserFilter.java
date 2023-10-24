package np.com.suulaav.backend.service.filter.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import np.com.suulaav.backend.core.service.filter.AbstractFilter;

/**
 * @author Sulav created on 10/24/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DefaultUserFilter extends AbstractFilter {
  private String userName;
}
