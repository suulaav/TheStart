package np.com.suulaav.backend.controller.user;

import java.util.Collections;
import java.util.Map;
import np.com.suulaav.backend.service.api.user.UserService;
import np.com.suulaav.backend.service.domain.user.UserAuthRequest;
import np.com.suulaav.backend.service.domain.user.UserAuthResponse;
import np.com.suulaav.backend.service.domain.user.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sulav created on 10/23/23
 */
@RestController
@RequestMapping("users")
public class UserController {
  UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(value = "auths")
  public ResponseEntity<UserAuthResponse> login(@RequestBody UserAuthRequest userAuthRequest) {
    return ResponseEntity.ok(this.userService.authenticate(userAuthRequest));
  }

  @PostMapping(value = "register")
  public ResponseEntity<Map<String, String>> register(@RequestBody UserDomain userDomain) {
    return ResponseEntity.ok(Collections.singletonMap("id", this.userService.register(userDomain)));
  }
}
