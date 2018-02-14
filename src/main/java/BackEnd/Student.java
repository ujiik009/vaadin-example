package BackEnd;

import java.time.LocalDate;

public class Student extends User{
	public Student(String zID, String name, String password, LocalDate DOB, String gender) {
        super(zID, name, password, DOB, gender);
    }

    public String getType() {
        return "Student";
    }
}
