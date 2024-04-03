/**
 * 
 */
package main;
import java.util.Scanner;
import java.util.List;

public class BreachCheckerApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an email address to check for breaches:");
        String email = scanner.nextLine();

        List<Breach> breaches = HIBPApiService.getBreachesForEmail(email);

        if (breaches.isEmpty()) {
            System.out.println("No breaches found for this email.");
        } else {
            for (Breach breach : breaches) {
            	System.out.println(breach.getDescription());
                System.out.println(breach.toString()); // Use Breach's overridden toString method to display details
                System.out.println("Press Enter to continue to the next breach...");
                scanner.nextLine(); // Wait for user input to continue
            }
        }
        scanner.close();
    }
}


