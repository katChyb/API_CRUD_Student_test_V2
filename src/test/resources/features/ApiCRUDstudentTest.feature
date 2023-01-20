Feature:  Student test
  Scenario:  API CRUD student test
    Given I create new Student
    Then new student is created successfully and exist in the system
    When I update this student and change his last name
    Then student last name is updated in the system
    When I delete this newly created student from the system
    Then this newly created student does not exist in the system