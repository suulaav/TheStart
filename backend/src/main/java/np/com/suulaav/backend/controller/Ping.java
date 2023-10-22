package np.com.suulaav.backend.controller;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sulav created on 10/21/23
 */
@RestController
public class Ping {

  @GetMapping(value = "ping")
  public ResponseEntity<Map<String, Object>> ping() {
    Map<String, Object> data = new HashMap<>();
    data.put("code", "0");
    data.put("data", Collections.singleton("hello"));
    data.put("time", new Date().getTime());
    return ResponseEntity.ok(data);
  }
}
