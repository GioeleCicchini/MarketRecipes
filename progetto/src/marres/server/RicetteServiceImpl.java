package marres.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import marres.client.RPC.RicetteService;
import marres.shared.DCategoria;
import marres.shared.DRicetta;

public class RicetteServiceImpl extends RemoteServiceServlet implements RicetteService {

	@Override
	public DRicetta[] getRicette(ArrayList<DRicetta>  symbols) {
		
		DRicetta ricetta1 = new DRicetta("Risotto al radicchio","bella ricetta");
		DRicetta ricetta2 = new DRicetta("Risotto allo zafferano","bella ricetta la seconda");
		DRicetta ricetta3 = new DRicetta("Risotto alla pescatora","bella ricetta la terza");
		DRicetta[] lista = new DRicetta[3];
		lista[0]= ricetta1;
		lista[1]= ricetta2;
		lista[2]= ricetta3;
		
		return lista;

	}



}
