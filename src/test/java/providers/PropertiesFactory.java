package providers;

import models.TestData;
import models.UrlData;
import utils.YamlReader;

import java.util.Map;

public class PropertiesFactory {
    YamlReader yamlReader = new YamlReader();
    protected UrlData urlData;
    protected TestData testData;

    private PropertiesFactory() {
        setUrlProperties();
        setTestDataProperties();
    }

    public static PropertiesFactory getInstance() {
        return PropertiesFactory.PropertiesFactorySingleton.INSTANCE;
    }

    private static class PropertiesFactorySingleton {
        private static final PropertiesFactory INSTANCE = new PropertiesFactory();
    }

    private void setUrlProperties() {

        urlData = yamlReader.getConfig().getUrlData();
        Map<String, Object> urlDataProperties = urlData.getUrlProperties();
        for (Map.Entry entry : urlDataProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
        }
    }

    private void setTestDataProperties() {

        testData = yamlReader.getConfig().getTestData();
        Map<String, Object> testDataProperties = testData.getDataProperties();
        for (Map.Entry entry : testDataProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
        }
    }
}
