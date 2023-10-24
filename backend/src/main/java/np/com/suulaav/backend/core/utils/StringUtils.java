package np.com.suulaav.backend.core.utils;

import java.util.UUID;

/**
 * @author Sulav created on 10/24/23
 */
public class StringUtils {

  public static boolean isNullOrBlank(String str) {
    return str == null || str.isEmpty() || str.isBlank();
  }

  public static String generateUUID() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }
  public static void main(String[] args){
    System.out.println(generateUUID());
  }
}
