package stepdefs;

import apiHelpersTest.ReqResSpecifications;
import apiHelpersTest.StudentFactory;
import apiHelpersTest.StudentResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
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
    private Student newStudent;
    int id;
    private StudentResponse studentResponse;
    private String NewLastName;




    @Given("I create new Student")
    public void i_create_new_student() {

        newStudent = StudentFactory.createRandomStudent();

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
                                .basePath(STUDENT_DETAILS_ENDPOINT + id).
                                when()
                                .get().
                                then()
                                .spec(specifications.setupResponseSpecification())
                                .statusCode(200)
                                .extract()
                                .as(StudentResponse.class);


        Assert.assertEquals(studentResponse.getData().getFirst_name(), newStudent.getFirst_name());
        log.info(">>>>>>>> get information about new student <<<<<<<<<" + studentResponse.getData().getFirst_name());

    }

    @When("I update this student and change his last name")
    public void iUpdateThisStudentAndChangeHisLastName() {

      StudentFactory.changeStudentLastName(studentResponse);

        log.info(">>>>>>>> changing student last name<<<<<<<<<");
                        given()
                                .spec(specifications.setupRequestSpecification())
                                .basePath(STUDENT_DETAILS_ENDPOINT + id)
                                .body(studentResponse.getData()).
                                when()
                                .put().
                                then()
                                .spec(specifications.setupResponseSpecification())
                                .statusCode(200);
    }

    @Then("student last name is updated in the system")
    public void studentLastNameIsUpdatedInTheSystem() {
                  NewLastName=

                        given()
                                .spec(specifications.setupRequestSpecification())
                                .basePath(STUDENT_DETAILS_ENDPOINT + id).
                                when()
                                .get().
                                then()
                                .spec(specifications.setupResponseSpecification())
                                .statusCode(200)
                                .extract()
                                .path("data.last_name");


        Assert.assertEquals(studentResponse.getData().getLast_name(), NewLastName);
        log.info(">>>>>>>> get information about updated last name <<<<<<<<<" );
    }

    @When("I delete this newly created student from the system")
    public void iDeleteThisNewlyCreatedStudentFromTheSystem() {
                        given()
                                .spec(specifications.setupRequestSpecification())
                                .basePath(STUDENT_DETAILS_ENDPOINT + id).
                                when()
                                .delete().
                                then()
                                .statusCode(200)
                                .spec(specifications.setupResponseSpecification());

        log.info(">>>>>>>> delete new student <<<<<<<<<");
    }

    @Then("this newly created student does not exist in the system")
    public void thisNewlyCreatedStudentDoesNotExistInTheSystem() {

        Response  response = null;
                          given()
                            .spec(specifications.setupRequestSpecification())
                            .basePath(STUDENT_DETAILS_ENDPOINT + id).
                            when()
                            .get().
                            then()
                            .statusCode(404);

                            Assert.assertEquals(response.statusCode(), 404);

        log.info(">>>>>>>> confirmation that new student was deleted <<<<<<<<<");

    }
}
