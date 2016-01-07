package marres.client.RPC;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DIngredienteDTO;
import marres.shared.dto.DRicettaDTO;

@RemoteServiceRelativePath("main")
public interface MainService extends RemoteService{
	
	List<DRicettaDTO> getRicette(DCategoriaDTO categoria);
	List<DCategoriaDTO> getCategorie();
	List<DIngredienteDTO> getIngredienti(DRicettaDTO ricetta);
	
	
}
