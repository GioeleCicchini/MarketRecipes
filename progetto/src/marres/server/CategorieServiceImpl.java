package marres.server;


import marres.client.RPC.CategorieService;
import marres.shared.DCategoria;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class CategorieServiceImpl extends RemoteServiceServlet implements CategorieService {


	@Override
	public DCategoria[] getCategorie(String[] symbols) {
		
		DCategoria categoria1 = new DCategoria("Primi");
		DCategoria categoria2 = new DCategoria("Secondi");
	
		DCategoria[] lista = new DCategoria[2];
		lista[0]= categoria1;
		lista[1]= categoria2;
		
		return lista;
	}

}
