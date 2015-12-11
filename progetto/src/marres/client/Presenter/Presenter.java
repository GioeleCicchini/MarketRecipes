package marres.client.Presenter;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.user.client.ui.Panel;

public interface Presenter {
	public DivElement getDivElement();
	public void bind();
	public void go(Panel panel);

}
