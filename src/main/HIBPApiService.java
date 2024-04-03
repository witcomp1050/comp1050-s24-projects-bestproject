/**
 * 
 */
package main;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 * Class for interacting with the Have I Been Pwned API.
 * This class provides functionality to check for breaches associated with an email address.
 */
public class HIBPApiService {
	//API key goes here
    private static final String API_KEY = "bb802bab664f41059dbea23c04d533e2";
    //base url for making http request before parameters, or api key
    private static final String EMAIL_CHECK_URL = "https://haveibeenpwned.com/api/v3/breachedaccount/";

    
    /**
     * Fetches breach information for the specified email address from the Have I Been Pwned API.
     * 
     * @param email The email address to check for breaches.
     * @return A list of Breach objects, each representing a breach the email adress was found in
     *         Returns an empty list if the email address is not found in any breaches.
     */
    public static List<Breach> getBreachesForEmail(String email) {
        List<Breach> breaches = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        
        // Constructing the request with the API key
        //its important to include the truncateResponse = false option or else you will only see the names of the breaches
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(EMAIL_CHECK_URL + email + "?truncateResponse=false"))
                .header("hibp-api-key", API_KEY)
                .header("User-Agent", "Java Application")//Not really sure what this means but you have to do it to avoid some errors
                .build();

        try {
            // Sending the request to the API and awaiting the response.
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //200 status code means success
            if (response.statusCode() == 200) {
            	 JSONArray breachesArray = new JSONArray(response.body());
            	    for (int i = 0; i < breachesArray.length(); i++) {
            	        JSONObject breachObj = breachesArray.getJSONObject(i);
            	        Breach breach = new Breach(
            	            breachObj.getString("Name"),
            	            breachObj.optString("Title", "N/A"), //optstrings allow us to have a default case in this case N/A
            	            breachObj.optString("Domain", "N/A"),
            	            breachObj.optString("BreachDate", "N/A"),
            	            breachObj.optLong("PwnCount", 0), 
            	            breachObj.optString("Description", "N/A"));
            	        breaches.add(breach);
            	    }
            	    return breaches;
            	}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return breaches;//either the populated list of breaches or an empty list if an error occured
    }
}
