/**
 * 
 */
package main;
import org.jsoup.Jsoup;
/**
 * 
 */
public class Breach {
	
	//here are all variables you can access via get methods(see below)
	//
	private String name;
    private String title;
    private String domain;
    private String breachDate;
    private long pwnCount;
    private String description;
    //api includes other properties that i omitted, we can add more though 
   
    /**
     * Constructs a new Breach instance with detailed information.
     * 
     * @param name The name of the breach.
     * @param title The display title of the breach.
     * @param domain The primary domain affected by the breach.
     * @param breachDate The date on which the breach occurred.
     * @param pwnCount The total number of accounts that were compromised.
     * @param description A detailed description of the breach.
     */
    public Breach(String name, String title, String domain, String breachDate, long pwnCount, String description) {
        this.name = name;
        this.title = title;
        this.domain = domain;
        this.breachDate = breachDate;
        this.pwnCount = pwnCount;
        this.description = description;
    }
    
    //get methods for acessing breach details
    public String getName() { return name; }
    //dont use the one below
    public String getTitle() { return title; }
    //dont use the one below
    public String getDomain() { return domain; }
    public String getBreachDate() { return breachDate; }
    public long getPwnCount() { return pwnCount; }
    
    //this one is different because I used Jsoup to remove the html tags from the description
    public String getDescription() {
    	return Jsoup.parse(description).text(); }

    /**
     * Returns a string representation of the breach, including its details.
     * This method is useful for logging or printing breach information.
     * I used this for testing my class, I assume we won't need the toString method in the final product
     * it still contains the html tags when printing the description
     * @return A string summarizing the breach details in the form the api provided.
     */
    @Override
    public String toString() {
        return "Name: " + name +
               "\nTitle: " + title +
               "\nDomain: " + domain +
               "\nBreach Date: " + breachDate +
               "\nPwnCount: " + pwnCount +
               "\nDescription: " + description;
    }
}