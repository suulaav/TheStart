package np.com.suulaav.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class BackendApplication {
  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(BackendApplication.class);
    app.setDefaultProperties(
        Collections.singletonMap("server.servlet.context-path", "/api"));
    app.run(args);
  }
}
