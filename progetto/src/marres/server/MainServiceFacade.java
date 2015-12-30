package marres.server;


import java.util.List;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import marres.client.RPC.MainService;
import marres.client.dto.DCategoriaDTO;
import marres.client.dto.DRicettaDTO;
import marres.server.service.CategoriaService;
import marres.server.service.RicettaService;

public class MainServiceFacade extends RemoteServiceServlet implements MainService {

	@Override
	public List<DRicettaDTO> getRicette(DCategoriaDTO categoria) {
			
		RicettaService ricetta = new RicettaService();
		
		return ricetta.PrelevaRicette();
		
	}

	@Override
	public List<DCategoriaDTO> getCategorie() {
		
		CategoriaService categoria = new CategoriaService();
		
		return categoria.PrelevaCategorie();

	}

}
