package BackEnd;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class User {
	    protected String zID;
	    protected String name;
	    protected String password;
	    protected LocalDate DOB;
	    protected String gender;
	    
	    public User(String zID, String name, String password, LocalDate DOB, String gender) {
	        this.zID = zID;
	        this.name = name;
	        this.password = password;
	        this.DOB = DOB;
	        this.gender = gender;
	    }

	    public String getID() {
	        return this.zID;
	    }

	    public String getName() {
	        return this.name;
	    }

	    public String getPassword() {
	        return this.password;
	    }

	    public LocalDate getDOB() {
	        return this.DOB;
	    }

	    public String getGender() {
	        return this.gender;
	    }

	    public String getType() {
	        return "";
	    }
	    
	    //can only be called by Teacher
	    public ArrayList<Class> getClasses() {
	        return new ArrayList<>();
	    }

	    public void addClass(Class class1) {
	        //leave blank
	    }

	    public void addClassToTeacher(String classID, String name) {
	        //leave blank
	    }

	    @Override
	    public String toString() {
	        return this.zID + ": " + this.name;
	    }
	    
	    
	    
}
