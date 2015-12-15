package marres.client.RPC;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import marres.shared.DCategoria;
import marres.shared.DRicetta;

public interface CategorieServiceAsync {

	void getCategorie(ArrayList<DCategoria>  symbols, AsyncCallback<DCategoria[]> callback);

}
