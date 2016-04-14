package com.zeptoh.lynk.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
//import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.zeptoh.lynk.common.CommonDaoImpl;
import com.zeptoh.lynk.model.SelectedContent;

public class UserGeneratedNotesList {
	
	
	 @SuppressWarnings("finally")
	//@Transactional
	    public JSONArray getUserGeneratedNotes(String userID){
		 EntityManager entityManager = CommonDaoImpl.setUpEntityManagerFactory().createEntityManager();
		 JSONArray jsonArray = null;
	    	try {
    Query query = entityManager.createNativeQuery("db.UserFactualContent.find( { \"E_MAIL\": \""+userID+"\" } )", SelectedContent.class);
				Gson gson = new Gson();
				List<SelectedContent> genList = query.getResultList();
				String resp = gson.toJson(genList);

				jsonArray = new JSONArray(resp);
				for(int i =0; i< jsonArray.length(); i++){
				    if(jsonArray.get(i) instanceof JSONObject){
				        JSONObject jsnObj = (JSONObject)jsonArray.get(i);
				       
				        jsnObj.remove("id");
				        jsnObj.remove("url");
				        jsnObj.remove("dummy2");
				        jsnObj.remove("userId");
				        jsnObj.remove("dummy1");
				        jsnObj.remove("data");
				        jsnObj.remove("flag");
				        jsnObj.put("restCall", "http://localhost:8080/LynkBeta/f/"+jsnObj.get("token"));
				        jsnObj.remove("token");
				    }
				}
				return jsonArray;
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				 return jsonArray;
			}finally{
				  entityManager.close();
				  CommonDaoImpl.closeEntityManagerFactory();
				  return jsonArray;
			}
	    }

}