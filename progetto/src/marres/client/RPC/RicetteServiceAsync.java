package marres.client.RPC;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import marres.shared.DRicetta;

public interface RicetteServiceAsync {
	void getRicette(ArrayList<DRicetta> ricette, AsyncCallback<DRicetta[]> callback);

}
