package apiHelpersTest;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class Data {

    private int id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String date_of_birth;

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", first_name'" + first_name + '\'' +
                ", middle_name'" + middle_name + '\'' +
                ", last_name'" + last_name + '\'' +
                ", date_of_birth'" + date_of_birth + '\'' +
                '}';
    }
}
