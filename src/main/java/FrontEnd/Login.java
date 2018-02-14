package FrontEnd;

import java.util.ArrayList;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.Position;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import BackEnd.MainSystem;
import BackEnd.Student;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class Login  extends VerticalLayout implements View{
	
	TextField tfID;
	PasswordField tfPassword;
	Button btnsignup,btnLogin;
	MainSystem mainSystem = new MainSystem();
	public Login() {
		// ui element
		tfID = new TextField("zID");
		tfPassword = new PasswordField("Password");
		
		// add Horizontal  layout for Button
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		
		// UI element - Button
		btnLogin = new Button("login");
		btnLogin.addStyleName("friendly");
		
		btnsignup = new Button("signup");
		btnsignup.addStyleName("primary");
		
		btnsignup.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo("signup");				
			}
		});
		
		// event login
		btnLogin.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				if(mainSystem.login(tfID.getValue(), tfPassword.getValue())) {
					getUI().getNavigator().navigateTo("dashbord");
					
				}else {
					Notification.show("Incorrect Login Details!", Notification.Type.ERROR_MESSAGE).setPosition(Position.TOP_RIGHT);
				}
			       
				
			}
		});
		
		// addcomponent
		
		horizontalLayout.addComponent(btnLogin);
		horizontalLayout.addComponent(btnsignup);
		horizontalLayout.setSpacing(true);
		
		FormLayout formLayout = new FormLayout(tfID,tfPassword,horizontalLayout);
		formLayout.setMargin(true);
		
		Panel loginpanel = new Panel("Login form",formLayout);

		loginpanel.setWidth("450");
		loginpanel.setHeight("250");
		addComponent(loginpanel);
		setComponentAlignment(loginpanel, ALIGNMENT_DEFAULT.MIDDLE_CENTER);
		setHeight("100%");
		
		
		
	}
	
	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	

}
