package marres.client.RPC;

import com.google.gwt.user.client.rpc.AsyncCallback;

import marres.shared.DCategoria;

public interface CategorieServiceAsync {

	void getCategorie(String[] symbols, AsyncCallback<DCategoria[]> callback);

}
