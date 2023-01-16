package models;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class Student {
    private String first_name;
    private String middle_name;
    private String last_name;
    private String date_of_birth;

    public Student(String first_name, String middle_name, String last_name, String date_of_birth) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
    }


}
