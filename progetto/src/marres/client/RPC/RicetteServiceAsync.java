package marres.client.RPC;


import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import marres.shared.DCategoria;
import marres.shared.DRicetta;

public interface RicetteServiceAsync {
	void getRicette(DCategoria categoria, AsyncCallback<DRicetta[]> callback);

}
