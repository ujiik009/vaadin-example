package FrontEnd;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.Position;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class Dashboard extends VerticalLayout implements View{

	public Dashboard() {
		addComponent(new Label("<h1>Dashbord</h1>",ContentMode.HTML));
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		View.super.enter(event);
		
		Notification.show("Welcome", Notification.Type.ASSISTIVE_NOTIFICATION).setPosition(Position.TOP_RIGHT);
	}
}
