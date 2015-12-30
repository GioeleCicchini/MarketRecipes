package marres.server;


import marres.client.RPC.CategorieService;
import marres.client.dto.DCategoriaDTO;
import marres.client.dto.DRicettaDTO;
import marres.client.util.HibernateUtil;
import marres.shared.domain.DCategoria;
import marres.shared.domain.DRicetta;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class CategorieServiceImpl extends RemoteServiceServlet implements CategorieService {


	@Override
	public DCategoriaDTO[] getCategorie() {
		
		
			    
		DCategoriaDTO categoria1 = new DCategoriaDTO();
		categoria1.setNome("Primi");
		
		DCategoriaDTO categoria2 = new DCategoriaDTO();
		categoria2.setNome("Secondi");
	
		DCategoriaDTO[] lista = new DCategoriaDTO[2];
		lista[0]= categoria1;
		lista[1]= categoria2;
		
		return lista;
	}

}
