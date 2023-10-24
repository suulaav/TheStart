package np.com.suulaav.backend.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import np.com.suulaav.backend.security.PublicResources;
import np.com.suulaav.backend.security.context.ApplicationContext;
import np.com.suulaav.backend.security.context.ApplicationRequestContextHolder;
import np.com.suulaav.backend.security.jwt.JwtHelper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(1)
public class SecurityInterceptor extends OncePerRequestFilter {
  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    this.handleHeaders(response);
    if ("OPTIONS".equals(request.getMethod())) {
      response.setStatus(HttpServletResponse.SC_OK);
      return;
    }
    if (!PublicResources.isAllowedResource(request)) {
      String token = request.getHeader("X-XSRF-TOKEN");
      if (token == null || token.isEmpty()) {
        response.sendError(403, "Please login");
        return;
      }
      this.validateAndSetContextFromToken(token, response);
    }
    chain.doFilter(request, response);
  }

  private void validateAndSetContextFromToken(String token, HttpServletResponse response) {
    Map<String, Object> datas = JwtHelper.parse(token);
    ApplicationContext applicationContext = new ApplicationContext();
    applicationContext.setUserName(datas.get("userName").toString());
    applicationContext.setSubject(datas.get("subject").toString());
    ApplicationRequestContextHolder.setContext(applicationContext);
    response.addHeader("X-XSRF-TOKEN", JwtHelper.generate(datas));
  }

  @Override
  public void destroy() {
    ApplicationRequestContextHolder.clear();
    super.destroy();
  }

  private void handleHeaders(HttpServletResponse response) {
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods", this.getAllowedMethods());
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers", "content-type, xsrf-token");
    response.addHeader("Access-Control-Expose-Headers", "X-XSRF-TOKEN");
  }

  protected String getAllowedMethods() {
    List<String> methods = new ArrayList<>();
    methods.add("GET");
    methods.add("POST");
    methods.add("PUT");
    methods.add("DELETE");
    methods.add("OPTIONS");
    methods.add("HEAD");
    return String.join(",", methods);
  }
}
