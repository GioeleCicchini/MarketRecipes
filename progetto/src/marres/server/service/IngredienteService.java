package marres.server.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.URL;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;

import marres.client.util.HibernateUtil;
import marres.shared.domain.DCategoria;
import marres.shared.domain.DIngrediente;
import marres.shared.domain.DRicetta;
import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DIngredienteDTO;
import marres.shared.dto.DRicettaDTO;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;

public class IngredienteService {
	
	
	public void IngredienteService(){
		
		
		
	}
	
	
	
	
	public List<DIngredienteDTO> PrelevaIngredienti(DRicettaDTO ricetta){
		
		DRicetta dricetta = null;
		
		dricetta=this.DTOToHibernate(ricetta);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<DIngrediente> IngredienteQuary = new ArrayList<DIngrediente>();
		List<DIngredienteDTO> IngredientiDTO = null ;
		
		try{
			session.beginTransaction();
			Criteria cr = session.createCriteria(DIngrediente.class, "ingrediente");
			cr.createAlias("ingrediente.ricette", "ricette");
			cr.add(Restrictions.eq("ricette.id", ricetta.getId()));
			IngredienteQuary = (List<DIngrediente>) cr.list();
			IngredientiDTO = this.HibernateToDTO(IngredienteQuary);
	}
	 catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} 
	finally{
			session.close();
		}
	
	return IngredientiDTO;
		
		
	}
	
private  List<DIngredienteDTO> HibernateToDTO(List<DIngrediente> ingredienti){
		
	List<DIngredienteDTO> ingredientiDTO = new ArrayList<DIngredienteDTO>(ingredienti != null ? ingredienti.size() : 0);
		
			    if (ingredienti != null) {
			    	List<String> myMappingFiles = new ArrayList<String>();
			    	myMappingFiles.add("marres/dozerBeanMapping.xml");
			    	DozerBeanMapper mapper = new DozerBeanMapper();
			    	mapper.setMappingFiles(myMappingFiles);
			    	
			    	  for (DIngrediente ingrediente : ingredienti) {
					    	
					        ingredientiDTO.add(mapper.map(ingrediente, DIngredienteDTO.class));
					       
				      }
			      
		
				       
			      }
			      
			    
		    return ingredientiDTO;
		
	}
	
	private DRicetta DTOToHibernate(DRicettaDTO ricetta){
		
		DRicetta dricetta = new DRicetta();
		
		if (ricetta != null) {
	    	List<String> myMappingFiles = new ArrayList<String>();
	    	myMappingFiles.add("marres/dozerBeanMapping.xml");
	    	DozerBeanMapper mapper = new DozerBeanMapper();
	    	mapper.setMappingFiles(myMappingFiles);
	    	
	    	dricetta = mapper.map(ricetta, DRicetta.class);
		}
		return dricetta;
		
	
	}
	
	
	

}
