package marres.client.RPC;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DIngredienteDTO;
import marres.shared.dto.DRicettaDTO;

public interface MainServiceAsync {

	void getRicette(DCategoriaDTO categoria, AsyncCallback<List<DRicettaDTO>> callback);
	void getCategorie(AsyncCallback<List<DCategoriaDTO>> callback);
	void getIngredienti(DRicettaDTO ricetta, AsyncCallback<List<DIngredienteDTO>> callback);
	
	
}
