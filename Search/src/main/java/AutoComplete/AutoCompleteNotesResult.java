package AutoComplete;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

public class AutoCompleteNotesResult {

	@SuppressWarnings("finally")
	public static JSONArray returnAutoCompleteQueryResult(String query) {
		EntityManager entityManager = PersistUserNContent
				.setUpEntityManagerFactory().createEntityManager();
		JSONArray jsonArray = null;
		try {
			Query content = entityManager
					.createNativeQuery(
							"db.UserFactualContent.find( {\"$or\": [ {\"NAME\":{\"$regex\":'(?i)"
									+ query
									+ "'}}, {\"DESCRIPTION\":{\"$regex\":'(?i)"
									+ query
									+ "'}},{\"DATA\":{ \"$regex\": '(?i)"
									+ query
									+ "' }}],\"$and\":[{\"FLAG\":\"public\" }]},{ \"DESCRIPTION\": \"1\",\"NAME\": \"1\",\"TOKEN\":\"1\"})",
							LynkedContentJpa.class);
			List<LynkedContentJpa> url = content.getResultList();
			Gson gson = new Gson();
			String resp = gson.toJson(url);

			jsonArray = new JSONArray(resp);
			for (int i = 0; i < jsonArray.length(); i++) {
				if (jsonArray.get(i) instanceof JSONObject) {
					JSONObject jsnObj = (JSONObject) jsonArray.get(i);
					jsnObj.remove("id");
					jsnObj.put("restCall", "http://localhost:8080/LynkBeta/f/"
							+ jsnObj.get("token"));
					jsnObj.remove("token");
				}
			}
			return jsonArray;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			entityManager.close();
			PersistUserNContent.closeEntityManagerFactory();
			return jsonArray;
		}
	}

}
