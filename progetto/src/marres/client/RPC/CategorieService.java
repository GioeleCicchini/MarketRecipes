package marres.client.RPC;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import marres.shared.DCategoria;

@RemoteServiceRelativePath("categorie")
public interface CategorieService extends RemoteService{
	
	DCategoria[] getCategorie(String[] symbols);

}
