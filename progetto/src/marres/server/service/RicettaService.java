package marres.server.service;

import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.google.gwt.user.server.Base64Utils;

import marres.client.util.HibernateUtil;
import marres.shared.domain.DCategoria;
import marres.shared.domain.DRicetta;
import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DRicettaDTO;

public class RicettaService {
	
	
	public RicettaService(){
		
		
	}
	

	public List<DRicettaDTO> PrelevaRicette(DCategoriaDTO categoria){
		
		DCategoria dcategoria = null;
		
		dcategoria=this.DTOToHibernate(categoria);
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<DRicetta> RicetteQuary = new ArrayList<DRicetta>();
		List<DRicettaDTO> ricetteDTO = null ;
		
		try{
				session.beginTransaction();
				Criteria cr = session.createCriteria(DRicetta.class);
				cr.add(Restrictions.eq("categoria", dcategoria));
				RicetteQuary = (List<DRicetta>) cr.list();
				ricetteDTO = this.HibernateToDTO(RicetteQuary);
		}
		 catch (HibernateException e) {
				session.getTransaction().rollback();
				e.printStackTrace();
			} 
		finally{
				session.close();
			}
		
		return ricetteDTO;
		
	}
	
	private  List<DRicettaDTO> HibernateToDTO(List<DRicetta> RicetteQuary){
		
		List<DRicettaDTO> ricetteDTO = new ArrayList<DRicettaDTO>(RicetteQuary != null ? RicetteQuary.size() : 0);
		
			    if (RicetteQuary != null) {
			    	List<String> myMappingFiles = new ArrayList<String>();
			    	myMappingFiles.add("marres/dozerBeanMapping.xml");
			    	DozerBeanMapper mapper = new DozerBeanMapper();
			    	mapper.setMappingFiles(myMappingFiles);
			    	
			      for (DRicetta ricetta : RicetteQuary) {
			    	
				        
				        ricetteDTO.add(mapper.map(ricetta, DRicettaDTO.class));
				       
			      }
			      
			      
			    }
		    return ricetteDTO;
		
	}
	
	private DCategoria DTOToHibernate(DCategoriaDTO categoria){
		
		DCategoria dcategoria = new DCategoria();
		
		if (categoria != null) {
	    	List<String> myMappingFiles = new ArrayList<String>();
	    	myMappingFiles.add("marres/dozerBeanMapping.xml");
	    	DozerBeanMapper mapper = new DozerBeanMapper();
	    	mapper.setMappingFiles(myMappingFiles);
	    	
	    	dcategoria = mapper.map(categoria, DCategoria.class);
		}
		return dcategoria;
		
	
	}
}
