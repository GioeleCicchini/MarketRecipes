package marres.client.RPC;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import marres.client.dto.DCategoriaDTO;
import marres.shared.domain.DCategoria;
import marres.shared.domain.DRicetta;

@RemoteServiceRelativePath("categorie")
public interface CategorieService extends RemoteService{
	
	DCategoriaDTO[] getCategorie();

}
