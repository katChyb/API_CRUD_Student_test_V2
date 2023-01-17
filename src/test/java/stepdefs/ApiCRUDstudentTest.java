package stepdefs;

import apiHelpersTest.ReqResSpecifications;
import apiHelpersTest.StudentFactory;
import apiHelpersTest.StudentResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import models.Student;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static apiHelpersTest.Endpoints.STUDENT_DETAILS_ENDPOINT;
import static io.restassured.RestAssured.given;

public class ApiCRUDstudentTest {

    private static final Logger log = LoggerFactory.getLogger("ApiCRUDstudentTest.class");
    private ReqResSpecifications specifications = new ReqResSpecifications();
    int id;
    StudentResponse studentResponse;


    @Given("I create new Student")
    public void i_create_new_student() {

        Student newStudent = StudentFactory.definedStudent();

       id =
             given()
                .spec(specifications.setupRequestSpecification())
                .basePath(STUDENT_DETAILS_ENDPOINT)
                .body(newStudent).
             when()
                .post().
             then()
                .spec(specifications.setupResponseSpecification())
                .statusCode(201)
                .extract()
                .path("id");

        log.info(">>>>>>>> create new student <<<<<<<<<");
    }

    @SneakyThrows
    @Then("new student is created successfully and exist in the system")
    public void GETnewStudentDetails() {

        studentResponse =
                given()
                        .spec(specifications.setupRequestSpecification())
                        .basePath(STUDENT_DETAILS_ENDPOINT+id).
                when()
                        .get().
                then()
                        .spec(specifications.setupResponseSpecification())
                        .statusCode(200)
                        .extract()
                        .as(StudentResponse.class);


        Assert.assertEquals(studentResponse.getData().getFirst_name(), System.getProperty("studentFirstName"));
        log.info(">>>>>>>> get information about new student <<<<<<<<<");
    }

    @When("I update this student and change his last name to middle name")
    public void iUpdateThisStudentAndChangeHisLastNameToMiddleName() {


    }
}
