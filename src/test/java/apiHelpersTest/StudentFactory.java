package apiHelpersTest;

import com.github.javafaker.Faker;
import models.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;


public class StudentFactory {

    private static final Logger log = LoggerFactory.getLogger("StudentFactory.class");

    static Faker usFaker = new Faker(new Locale("en-US"));

    public static Student createRandomStudent(){

       log.info("<<<<<<<<<<<<<<< new random Student  >>>>>>>>>>>>>>> ");

     return   Student.builder()
                .first_name(usFaker.name().firstName())
                .middle_name(usFaker.name().firstName())
                .last_name(usFaker.name().lastName())
                .date_of_birth(String.valueOf(usFaker.date().birthday()))
                .build();
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
        item.getData().setLast_name(usFaker.name().name());
    }
}
