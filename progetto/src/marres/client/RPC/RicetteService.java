package marres.client.RPC;

import java.util.ArrayList;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import marres.shared.DRicetta;


@RemoteServiceRelativePath("ricette")
public interface RicetteService extends RemoteService {
	
	DRicetta[] getRicette(ArrayList<DRicetta>  symbols);

}
