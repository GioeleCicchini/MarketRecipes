package marres.client.Controller;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import marres.client.View.*;

public class Entry implements EntryPoint {
  public void onModuleLoad() {
	 RootPanel.get().add(new View());
	 
  }
}