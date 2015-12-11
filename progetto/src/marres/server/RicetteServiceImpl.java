package marres.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import marres.client.RPC.RicetteService;
import marres.shared.DCategoria;
import marres.shared.DRicetta;

public class RicetteServiceImpl extends RemoteServiceServlet implements RicetteService {

	@Override
	public DRicetta[] getRicette(ArrayList<DRicetta>  symbols) {
		
		DRicetta ricetta1 = new DRicetta("cioa","bella ricetta");
		DRicetta ricetta2 = new DRicetta("seconda","bella ricetta la seconda");;
	
		DRicetta[] lista = new DRicetta[2];
		lista[0]= ricetta1;
		lista[1]= ricetta2;
		
		return lista;

	}



}
