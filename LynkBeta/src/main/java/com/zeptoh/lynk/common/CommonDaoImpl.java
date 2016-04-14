package com.zeptoh.lynk.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.gson.Gson;
import com.zeptoh.lynk.model.SelectedContent;


public class CommonDaoImpl implements CommonDao {
	
	static EntityManagerFactory entityManagerFactory;
	
	public static EntityManagerFactory setUpEntityManagerFactory() {
        return entityManagerFactory = Persistence.createEntityManagerFactory( "MongoJpa" );
    }

    public static void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }

	@Override
	public void storeLynk(Object obj) {
		
		EntityManager entityManager = CommonDaoImpl.setUpEntityManagerFactory().createEntityManager();
		try{
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
	}finally{
		  entityManager.close();
		  CommonDaoImpl.closeEntityManagerFactory();
		 }
}


	@Override
	public SelectedContent retrieveLynk(String token) {
		SelectedContent authors = null;
		
			String dataSelected = " ";
			
			EntityManager entityManager = CommonDaoImpl.setUpEntityManagerFactory().createEntityManager();
			try {
			Query query = entityManager.createNativeQuery("db.UserFactualContent.find( { \"TOKEN\": \""+token+"\" } )", SelectedContent.class);
			
			Gson gson = new Gson();
     authors = (SelectedContent) query.getSingleResult();
			String resp = gson.toJson(authors);
			
			JSONObject jsObj = new JSONObject(resp);
			dataSelected = (String) jsObj.get("data");
	           dataSelected = dataSelected.replaceAll(" ", "lynk_space");
	           dataSelected = dataSelected.replaceAll(">", "lynk_endtag");
	           authors.setData(dataSelected);
			return authors;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return authors;
		}finally{
			  entityManager.close();
			  CommonDaoImpl.closeEntityManagerFactory();
			 }
	}

}
