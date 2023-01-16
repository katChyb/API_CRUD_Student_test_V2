package apiHelpersTest;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

    private String status;
    private Data data;
}
