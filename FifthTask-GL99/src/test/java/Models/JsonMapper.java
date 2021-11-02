package Models;

import java.util.HashMap;
import java.util.Map;

public class JsonMapper {

    private Map<String, Object> jsonMap = new HashMap<>();


    public Map registerUserWith2Keys(String key1, String value1, String key2, String value2) {
        jsonMap.put(key1,value1);
        jsonMap.put(key2, value2);
        return jsonMap;
    }

    public Map registerUserWith1Key(String key1, String value1) {
        jsonMap.put(key1,value1);
        return jsonMap;
    }





}
