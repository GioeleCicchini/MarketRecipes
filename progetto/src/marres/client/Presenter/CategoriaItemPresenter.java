package marres.client.Presenter;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;


public class CategoriaItemPresenter implements Presenter {

	
	Display view;
	
	public interface Display {
		public DivElement getDivElement();
		public void AggiungiCategoria(DivElement categoria);
		public void clear();
		public Widget asWidget();
		public void setPresenter(CategoriaItemPresenter presenter);
		public void setCategoria(String categoria);
		
	}
	
	public CategoriaItemPresenter(Display view){
		this.view = view;
		bind();
	}
	
	@Override
	public void InizializzaEventiView() {
		// TODO Auto-generated method stub
		
	}
	
	public void setCategoria(String categoria){
		view.setCategoria(categoria);
		
	}
	
	@Override
	public DivElement getDivElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bind() {
		view.setPresenter(this);
	}

	
	
	
	
	

}
