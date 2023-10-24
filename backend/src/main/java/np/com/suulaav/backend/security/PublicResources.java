package np.com.suulaav.backend.security;

import jakarta.servlet.http.HttpServletRequest;

public class PublicResources {
  private PublicResources() {}

  public static boolean isAllowedResource(HttpServletRequest request) {
    String[] resourceList = {"ping", "public", "auths", "register"};
    for (String str : resourceList) {
      if (request.getRequestURL().toString().contains(str)) {
        return true;
      }
    }
    return false;
  }
}
