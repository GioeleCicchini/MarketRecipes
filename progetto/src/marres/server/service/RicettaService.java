package marres.server.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import marres.client.dto.DRicettaDTO;
import marres.client.util.HibernateUtil;
import marres.shared.domain.DRicetta;

public class RicettaService {
	
	
	public RicettaService(){
		
		
	}
	

	public List<DRicettaDTO> PrelevaRicette(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<DRicetta> RicetteQuary = new ArrayList<DRicetta>();
		try{
		session.beginTransaction();
		Criteria cr = session.createCriteria(DRicetta.class);
		RicetteQuary = (List<DRicetta>) cr.list();
	
		}
		 catch (HibernateException e) {
				session.getTransaction().rollback();
				e.printStackTrace();
			} 
		finally{
				session.close();
			}
		return this.HibernateToDTO(RicetteQuary);
		
	}
	
	private  List<DRicettaDTO> HibernateToDTO(List<DRicetta> RicetteQuary){
		
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
	
}
