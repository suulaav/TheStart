package np.com.suulaav.backend.core.utils;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

/**
 * @author Sulav created on 10/24/23
 */
public class SecurityUtils {
    public static String oneWayEncoding(String code){
        return Hashing.sha512().hashString(code, StandardCharsets.UTF_8).toString();
    }
    public static void main(String[] args){
    System.out.println(oneWayEncoding("password"));
    }
}
