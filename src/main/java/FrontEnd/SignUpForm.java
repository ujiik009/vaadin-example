package FrontEnd;

import java.util.ArrayList;
import java.util.Date;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.sass.ArgumentParser.Option;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import BackEnd.MainSystem;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class SignUpForm extends VerticalLayout implements View {
	
	Label lblTitle;
    Label lblHeader;
    TextField tfID;
    TextField tfName;
    PasswordField tfPassword;
    DateField dfDOB;
    ComboBox cbType;
    Button btnConfirm;
    Button btnCancel;
    RadioButtonGroup<String> opGender;
    MainSystem main;
    public SignUpForm() {
    	
    	main = new MainSystem();//connect to backend
    	
    	
    	// INSTALL SETUP    	
    	setSpacing(true);
    	setMargin(true);
    	
    	// up element	
    	lblTitle = new Label("Sign up Form");
    	lblTitle.addStyleName("h1");
    	addComponent(lblTitle);
    	
    	//sign up Form
    	FormLayout formLayout = new FormLayout();
    	formLayout.setMargin(false);
    	formLayout.setWidth("50%");
    	formLayout.addStyleName("light");
    	
    	addComponent(formLayout);

    	lblHeader = new Label("Personal Infomation");
    	lblHeader.addStyleName("h2");
    	lblHeader.addStyleName("colored");
    	formLayout.addComponent(lblHeader);
    	
    	tfID = new TextField("zID");
    	tfID.setRequiredIndicatorVisible(true);
    	formLayout.addComponent(tfID);
    	
    	tfName = new TextField("Name");
    	tfName.setRequiredIndicatorVisible(true);
    	formLayout.addComponent(tfName);
    	
    	tfPassword = new PasswordField("Password");
    	tfPassword.setRequiredIndicatorVisible(true);
    	formLayout.addComponent(tfPassword);
    	
    	dfDOB = new DateField("date of birth");
    	dfDOB.setDateFormat("dd-MM-yyyy");
    	dfDOB.setRequiredIndicatorVisible(true);
    	formLayout.addComponent(dfDOB);
    	
    	ArrayList<String> listType = new ArrayList<>();
    	
    	listType.add("staff");
    	listType.add("student");
    	
    	cbType = new ComboBox<>("type",listType);
    	cbType.setRequiredIndicatorVisible(true);
    	cbType.setValue(listType.get(0));
    	formLayout.addComponent(cbType);
    	
    	opGender = new RadioButtonGroup<>();
    	opGender.setItems("Male","Female");
    	opGender.addStyleName("horizontal");
    	formLayout.addComponent(opGender);
    	
    	btnConfirm = new Button("Confirm");
    	btnConfirm.addStyleName("primary");
    	this.eventConfirm();
    	
    	
    	
    	btnCancel = new Button("cancel");
    	btnCancel.addStyleName("danger");
    	this.eventCancel();
    	// footer
    	HorizontalLayout footer  = new HorizontalLayout();
    	footer.setMargin(new MarginInfo(true, false, true, false));
    	footer.setSpacing(true);
    	footer.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
    	formLayout.addComponent(footer);
    	footer.addComponent(btnConfirm);
    	footer.addComponent(btnCancel);
    	
    	setComponentAlignment(formLayout, Alignment.MIDDLE_CENTER);
    	
    	
	}
    
	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	private void eventConfirm() {
		// event click confirm
    	btnConfirm.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				main.signUp(
						tfID.getValue(),
						tfName.getValue(),
						tfPassword.getValue(),
						cbType.getValue().toString(),
						dfDOB.getValue(),
						opGender.getValue()						
				);
					
				
				Notification notif = new Notification(
					    "Warning",
					    "",
					    Notification.TYPE_HUMANIZED_MESSAGE);
				
				notif.setPosition(Position.BOTTOM_RIGHT);
				notif.show(Page.getCurrent());
			}
		});
	}
	
	private void eventCancel() {
		btnCancel.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo("login");
				
			}
		});
	}
}
