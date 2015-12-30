package marres.client.RPC;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import marres.client.dto.DCategoriaDTO;
import marres.client.dto.DRicettaDTO;

public interface MainServiceAsync {

	void getRicette(DCategoriaDTO categoria, AsyncCallback<List<DRicettaDTO>> callback);
	void getCategorie(AsyncCallback<List<DCategoriaDTO>> callback);
	
	
}
