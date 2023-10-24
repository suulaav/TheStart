package np.com.suulaav.backend.controller.user;

import np.com.suulaav.backend.security.context.ApplicationContext;
import np.com.suulaav.backend.security.context.ApplicationRequestContextHolder;
import np.com.suulaav.backend.service.api.user.auth.AuthService;
import np.com.suulaav.backend.service.domain.user.AuthRequest;
import np.com.suulaav.backend.service.domain.user.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sulav created on 10/23/23
 */
@RestController
@RequestMapping("auths")
public class AuthController {
  AuthService authService;

  @Autowired
  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping
  public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
    return ResponseEntity.ok(this.authService.authenticate(authRequest));
  }
}
