package models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class UrlData {

    Map<String, Object> urlProperties = new LinkedHashMap<>();

    @JsonAnySetter
    void setUrlProperties (String key, Object value) {
        urlProperties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getUrlProperties() {
        return urlProperties;
    }
}
