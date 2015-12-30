package marres.client.RPC;


import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import marres.client.dto.DCategoriaDTO;
import marres.client.dto.DRicettaDTO;



@RemoteServiceRelativePath("ricette")
public interface RicetteService extends RemoteService {
	
	List<DRicettaDTO> getRicette(DCategoriaDTO categoria);

}
