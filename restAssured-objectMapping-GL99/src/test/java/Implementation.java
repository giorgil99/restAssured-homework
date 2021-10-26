import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Implementation {

    private Map<String, Object> jsonMap = new HashMap<>();


    public Map RegisterUser(String email, String password) {
        jsonMap.put("email",email);
        jsonMap.put("password", password);
        return jsonMap;
    }


}
