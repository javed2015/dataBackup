package AutoComplete;

import java.net.UnknownHostException;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;
//import javax.transaction.Transactional;

public class RetrieveList {

	public static void main(String[] args) throws UnknownHostException {
		System.out.println(RetrieveList.canPersistAndLoadPersonAndHikes());
	}

	@SuppressWarnings("finally")
	//@Transactional
	public static Set<String> canPersistAndLoadPersonAndHikes() {
		EntityManager entityManager = PersistUserNContent
				.setUpEntityManagerFactory().createEntityManager();
		Set<String> primesWithoutDuplicates = null;

		try {
			// 8gphgbceqqlih270b3993mian7
			/*
			 * Query description = entityManager .createNativeQuery(
			 * "db.UserFactualContent.find( {\"FLAG\":\"public\" }, { \"DESCRIPTION\": \"1\", \"_id\":\"0\",\"NAME\": \"1\"} )"
			 * , LynkedContentJpa.class); List<LynkedContentJpa> desc =
			 * description.getResultList(); primesWithoutDuplicates = new
			 * LinkedHashSet<String>(); for (LynkedContentJpa a : desc) {
			 * primesWithoutDuplicates.add(a.getName());
			 * primesWithoutDuplicates.add(a.getDescription()); }
			 */
			String a = "8gphgbceqqlih270b3993mian7";
			entityManager.getTransaction().begin();
			Query desc = entityManager
					.createNativeQuery("db.UserFactualContent.update({'TOKEN':'8gphgbceqqlih270b3993mian7'},{'$inc':{'clicks': 1}})");
			System.out.println(desc.executeUpdate());
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			entityManager.close();
			PersistUserNContent.closeEntityManagerFactory();
			return primesWithoutDuplicates;
		}
	}

}
