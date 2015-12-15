package marres.client.RPC;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import marres.shared.DCategoria;
import marres.shared.DRicetta;

@RemoteServiceRelativePath("categorie")
public interface CategorieService extends RemoteService{
	
	DCategoria[] getCategorie(ArrayList<DCategoria>  symbols);

}
