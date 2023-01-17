package stepdefs;


import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.PropertiesFactory;


public class TestBase {
    private static PropertiesFactory propertiesFactory;
    private static Logger log = LoggerFactory.getLogger(TestBase.class);

    @BeforeAll
    public static void setup() {
        log.info(">>>>>>>> Before all started <<<<<<<<<");
        propertiesFactory = PropertiesFactory.getInstance();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

}
