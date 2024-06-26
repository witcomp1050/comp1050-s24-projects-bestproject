package main;


/**
 *  Class to check the strength of passwords based on NIST standards.
 */
public class passwordStrengthCheck {
	
	// password must contain at least 8 characters and no more than 64 characters
	// password must contain at least 1 uppercase letter		
	// password must contain at least 1 lowercase letter
	// password must contain at least 1 number
	
	public static String checkStrength(String password) {
	    // Check if the password is empty
	    if (password.isEmpty()) {
	        return "Please supply a password";
	    }

	    boolean upperCaseLetter = false;
	    boolean lowerCaseLetter = false;
	    boolean number = false;
	    boolean length = false;
	    String strongPassword = "Your password meets NIST standards";
	    String weakPassword = "Your password does not meet NIST standards because";

	    // Check password characteristics
	    if (password.length() >= 8 && password.length() <= 64) {
	        length = true;
	    }

	    for (int i = 0; i < password.length(); i++) {
	        char ch = password.charAt(i);
	        if (Character.isDigit(ch)) {
	            number = true;
	        } 
	        else if (Character.isUpperCase(ch)) {
	            upperCaseLetter = true;
	        } 
	        else if (Character.isLowerCase(ch)) {
	            lowerCaseLetter = true;
	        }
	    }

	    // Check if all criteria are met
	    if (length && number && upperCaseLetter && lowerCaseLetter) {
	        return strongPassword;
	    } else {
	        if (!length) {
	        	weakPassword = weakPassword + ", password must be between 8 and 64 characters";
	        }
	        if (!number) {
	        	weakPassword = weakPassword + ", password must contain at least 1 number";
	        }
	        if (!upperCaseLetter) {
	        	weakPassword = weakPassword + ", password must contain at least 1 uppercase letter";
	        }
	        if (!lowerCaseLetter) {
	        	weakPassword = weakPassword + ", password must contain at least 1 lowercase letter";
	        }
	        return weakPassword;
	    }
	}

}
