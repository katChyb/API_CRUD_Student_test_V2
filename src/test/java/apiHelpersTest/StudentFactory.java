package apiHelpersTest;

import com.github.javafaker.Faker;
import models.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;


public class StudentFactory {

    private static final Logger log = LoggerFactory.getLogger("StudentFactory.class");

    static Faker usFaker = new Faker(new Locale("en-US"));

    public static StudentRequestBody createRandomStudent(){

       log.info("<<<<<<<<<<<<<<< new random Student  >>>>>>>>>>>>>>> ");
        return new StudentRequestBody(
                usFaker.name().firstName(),
                usFaker.name().name(),
                usFaker.name().lastName(),
                usFaker.date().birthday(18,65)
        );
    }

    public static Student definedStudent(){
        return  Student.builder()
                .first_name(System.getProperty("studentFirstName"))
                .middle_name(System.getProperty("studentMiddleName"))
                .last_name(System.getProperty("studentLastName"))
                .date_of_birth(System.getProperty("studentDateOfBirth"))
                .build();
    }

    public static void changeStudentLastName(StudentResponse item) {
        log.info("<<<<<<<<<< Change Last Name for Student >>>>>>>>>");
        item.getData().setLast_name(System.getProperty("studentMiddleName"));
    }
}
