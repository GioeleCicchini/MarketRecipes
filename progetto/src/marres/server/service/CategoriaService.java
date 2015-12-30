package marres.server.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import marres.client.dto.DCategoriaDTO;
import marres.client.dto.DRicettaDTO;
import marres.client.util.HibernateUtil;
import marres.shared.domain.DCategoria;
import marres.shared.domain.DRicetta;

public class CategoriaService {
	
	public CategoriaService(){}
	
	public List<DCategoriaDTO> PrelevaCategorie(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<DCategoria> CategorieQuary = new ArrayList<DCategoria>();
		
		try{
		session.beginTransaction();
		Criteria cr = session.createCriteria(DCategoria.class);
		CategorieQuary = (List<DCategoria>) cr.list();
		
		}
		 catch (HibernateException e) {
				session.getTransaction().rollback();
				e.printStackTrace();
			} 
		finally{
				session.close();
			}
		
		return this.HibernateToDTO(CategorieQuary);
		
		
		
	}
	
	private  List<DCategoriaDTO> HibernateToDTO(List<DCategoria> CategorieQuary){
	
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
