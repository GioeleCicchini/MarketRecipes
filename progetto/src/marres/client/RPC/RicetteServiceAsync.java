package marres.client.RPC;


import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import marres.client.dto.DCategoriaDTO;
import marres.client.dto.DRicettaDTO;



public interface RicetteServiceAsync {
	void getRicette(DCategoriaDTO categoria, AsyncCallback<List<DRicettaDTO>> callback);

}
