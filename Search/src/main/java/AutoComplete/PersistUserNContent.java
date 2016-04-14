package AutoComplete;

import java.net.UnknownHostException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import javax.transaction.Transactional;

public class PersistUserNContent {
	
static EntityManagerFactory entityManagerFactory;
	 
	/* public static void main(String []args) throws UnknownHostException{
	 PersistUserNContent st = new PersistUserNContent();
		 PersistUserNContent.setUpEntityManagerFactory();
		 
		 st.canPersistAndLoadPersonAndHikes();
		 PersistUserNContent.closeEntityManagerFactory();
	 }*/

	    public static EntityManagerFactory setUpEntityManagerFactory() {
	        return entityManagerFactory = Persistence.createEntityManagerFactory( "MongoJpa" );
	    }

	    public static void closeEntityManagerFactory() {
	        entityManagerFactory.close();
	    }
	    
	//   @Transactional
	    public void canPersistAndLoadPersonAndHikes() throws UnknownHostException {
		   EntityManager entityManager = null;
	    	try {
		entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();
     entityManager.getTransaction().commit();
				entityManager.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				entityManager.close();
			}
	    }


}
