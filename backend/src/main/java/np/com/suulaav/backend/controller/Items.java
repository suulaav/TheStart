package np.com.suulaav.backend.controller;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Sulav created on 10/15/23
 */
@Data
@Document("items")
public class Items {
  @Id private Object id;
  private String name;
  private int quantity;
  private String category;
}
