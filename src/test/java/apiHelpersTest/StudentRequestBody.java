package apiHelpersTest;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class StudentRequestBody {

    private String first_name;
    private String middle_name;
    private String last_name;
    private String date_of_birth;

    public StudentRequestBody(String first_name, String name, String last_name, Date birthday) {
    }
}
