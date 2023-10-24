package np.com.suulaav.backend.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sulav created on 10/23/23
 */
public class JwtHelper {

  private static byte[] KEY =
      "THIS_IS_SUPER_DUPER_ULTRA_SECRET_KEY_THAT_IS_NOT_KNOWN_BY_ANYONE".getBytes();

  public static String generate(Map<String, Object> claims) {
    return Jwts.builder()
        .subject(claims.get("subject").toString())
        .issuer("SYSTEM")
        .claims(claims)
        .issuedAt(Date.from(Instant.now()))
        .expiration(Date.from(Instant.now().plus(30, ChronoUnit.MINUTES)))
        .signWith(Keys.hmacShaKeyFor(KEY))
        .compact();
  }

  public static Map<String, Object> parse(String token) {
    Claims claims =
        Jwts.parser()
            .verifyWith(Keys.hmacShaKeyFor(KEY))
            .build()
            .parseSignedClaims(token)
            .getPayload();
    int expired = claims.getExpiration().compareTo(Date.from(Instant.now()));
    if (expired < 0) {
      throw new RuntimeException("Token Expired");
    }
    return new HashMap<>(claims);
  }
}
