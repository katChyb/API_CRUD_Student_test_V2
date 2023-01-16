package models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestData {
    Map<String, Object> testDataProperties = new LinkedHashMap<>();

    @JsonAnySetter
    void setDataProperties (String key, Object value) {
        testDataProperties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getDataProperties() {
        return testDataProperties;
    }
}
