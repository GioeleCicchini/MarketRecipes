package marres.client.RPC;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import marres.client.dto.DCategoriaDTO;
import marres.shared.domain.DCategoria;
import marres.shared.domain.DRicetta;

public interface CategorieServiceAsync {

	void getCategorie(AsyncCallback<DCategoriaDTO[]> callback);

}
