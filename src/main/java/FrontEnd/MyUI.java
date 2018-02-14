package FrontEnd;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.Position;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	Boolean status_login = false;
    @Override
    protected void init(VaadinRequest vaadinRequest) {

    	Navigator navigator = new Navigator(this, this);
    	// login add view
    	 	
    	// login 
     	navigator.addView("login", new Login());
     
     	// sing up 
     	navigator.addView("signup", new SignUpForm());
     	
     	// dashbord 
     	navigator.addView("dashbord", new Dashboard());
        
    	
     	if(status_login!=true) {
     		getUI().getNavigator().navigateTo("login");
     	}
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    	
    	
    }
}
