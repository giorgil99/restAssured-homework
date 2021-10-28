package DeserialisationTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Implementation {

    private Map<String, Object> jsonMap = new HashMap<>();


    public Map RegisterUserWith2Keys(String key1, String value1, String key2,  String value2) {
        jsonMap.put(key1,value1);
        jsonMap.put(key2, value2);
        return jsonMap;
    }

    public Map RegisterUserWith1Keys(String key1, String value1) {
        jsonMap.put(key1,value1);
        return jsonMap;
    }

}
