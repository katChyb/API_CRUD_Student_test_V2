package apiHelpersTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class ReqResSpecifications {

    public RequestSpecification setupRequestSpecification() {
        return RestAssured.given()
                .baseUri(System.getProperty("baseURL"))
                .contentType(ContentType.JSON);
    }

    public ResponseSpecification setupResponseSpecification() {
        return RestAssured.expect()
                .contentType(ContentType.JSON);
    }

}
