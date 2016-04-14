package AutoComplete;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONObject;
 
public class DummyDB {
    private int totalCountries;
    private List<String> countries;
    public DummyDB() {
       
    }
     
    @SuppressWarnings("finally")
	public JSONArray getData(String query) {
    	JSONArray jArr= new JSONArray();
    	List<String> matched = null;
    	JSONObject jObj = null;
    	 try {
			countries = new ArrayList<String>(RetrieveList.canPersistAndLoadPersonAndHikes()) ;
			 totalCountries = countries.size();
			String country = null;
			query = query.toLowerCase();
			matched = new ArrayList<String>();
			for(int i=0; i<totalCountries; i++) {
			    country = countries.get(i).toLowerCase(Locale.ENGLISH);			    
			    if(country.startsWith(query)) {
			    	jObj = new JSONObject();
			    	jObj.put("label", countries.get(i));
			    	jObj.put("value", countries.get(i));
			    	jArr.put(jObj);
			    }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return jArr;
		}
    }
}