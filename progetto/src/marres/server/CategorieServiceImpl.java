package marres.server;


import marres.client.RPC.CategorieService;
import marres.shared.DCategoria;
import marres.shared.DRicetta;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class CategorieServiceImpl extends RemoteServiceServlet implements CategorieService {


	@Override
	public DCategoria[] getCategorie(ArrayList<DCategoria> symbols) {
		
		DCategoria categoria1 = new DCategoria();
		categoria1.setNome("Primi");
		
		DCategoria categoria2 = new DCategoria();
		categoria2.setNome("Secondi");
	
		DCategoria[] lista = new DCategoria[2];
		lista[0]= categoria1;
		lista[1]= categoria2;
		
		return lista;
	}

}
