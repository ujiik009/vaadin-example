package BackEnd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import com.vaadin.ui.Notification;

public class MainSystem {
	private static ArrayList<User> userList = new ArrayList<>();
	private static User currentUser;
	Writer writer = null;
	
	public ArrayList<User> getUserList(){
		return this.userList;
	}
	
	public User getCurrentUser() {
		return this.currentUser;
	}
	
	public void signUp(String zID,String name, String password, String type ,LocalDate DOB,String gender) {
//		ArrayList<String> data = new ArrayList<>();
//		data.add(zID);
//		data.add(name);
//		data.add(password);
//		data.add(type);
//		data.add(DOB.toString());
//		data.add(gender);	
		
		
		if(type.equals("student")) {
			//Student student = new Student("zID", "name", "password", "DOB", "gender");
			Student student = new Student(zID, name, password, DOB, gender);
			
			userList.add(student);
		}else {	
			Student student = new Student(zID, name, password, DOB, gender);
			userList.add(student);
		}
		
		
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("filename.txt"), "utf-8"));
		    writer.write(userList.toString());
		} catch (IOException ex) {
		  // report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
		
		
	}
	
	public Boolean login(String zID, String password ) {
		
		 for (User user : userList) {
	            if (user.zID.equals(zID) && user.password.equals(password)) {
	                this.currentUser = user;
	                return true;    //move to next screen
	            }
	        }
	        return false;   //show notification
	}
}
