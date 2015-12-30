package marres.server;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import marres.client.RPC.MainService;
import marres.client.dto.DCategoriaDTO;
import marres.client.dto.DRicettaDTO;
import marres.client.util.HibernateUtil;
import marres.shared.domain.DCategoria;
import marres.shared.domain.DRicetta;

public class MainServiceFacade extends RemoteServiceServlet implements MainService {

	@Override
	public List<DRicettaDTO> getRicette(DCategoriaDTO categoria) {
Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
		List<DRicetta> RicetteQuary = new ArrayList<DRicetta>();

		Criteria cr = session.createCriteria(DRicetta.class);
		
		RicetteQuary = (List<DRicetta>) cr.list();
		
		List<DRicettaDTO> ricetteDTO = new ArrayList<DRicettaDTO>(
		       RicetteQuary != null ? RicetteQuary.size() : 0);
		    if (RicetteQuary != null) {
		    	List<String> myMappingFiles = new ArrayList<String>();
		    	myMappingFiles.add("marres/dozerBeanMapping.xml");
		    	DozerBeanMapper mapper = new DozerBeanMapper();
		    	mapper.setMappingFiles(myMappingFiles);
		    	
		      for (DRicetta ricetta : RicetteQuary) {
		        ricetteDTO.add(mapper.map(
		            ricetta, DRicettaDTO.class));
		      }
		    }

			return ricetteDTO;
	}

	@Override
	public List<DCategoriaDTO> getCategorie() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
		List<DCategoria> CategorieQuary = new ArrayList<DCategoria>();

		Criteria cr = session.createCriteria(DCategoria.class);
		
		CategorieQuary = (List<DCategoria>) cr.list();
		
		
		List<DCategoriaDTO> categorieDTO = new ArrayList<DCategoriaDTO>(
			       CategorieQuary != null ? CategorieQuary.size() : 0);
			    if (CategorieQuary != null) {
			    	List<String> myMappingFiles = new ArrayList<String>();
			    	myMappingFiles.add("marres/dozerBeanMapping.xml");
			    	DozerBeanMapper mapper = new DozerBeanMapper();
			    	mapper.setMappingFiles(myMappingFiles);
			    	
			      for (DCategoria categoria : CategorieQuary) {
			        categorieDTO.add(mapper.map(
			            categoria, DCategoriaDTO.class));
			      }
			    }
		
		return categorieDTO;
	}

}
