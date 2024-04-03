package application;


public class passwordStrengthCheck {
	
	// password must contain at least 8 characters
	// password must contain at least 1 uppercase letter		
	// password must contain at least 1 lowercase letter
	// password must contain at least 1 number
	
	private static boolean checkStrength(String password) {
	    char ch;
	    boolean upperCaseLetter = false;
	    boolean lowerCaseLetter = false;
	    boolean number = false;
	    boolean length = false;
	    for(int i = 0; i < password.length(); i++) {
	    	if (password.length() >= 8) {
	    		length = true;
	    	}
	        ch = password.charAt(i);
	        if (Character.isDigit(ch)) {
	            number = true;
	        }
	        else if (Character.isUpperCase(ch)) {
	            upperCaseLetter = true;
	        } 
	        else if (Character.isLowerCase(ch)) {
	            lowerCaseLetter = true;
	        }
	        if (length && number && upperCaseLetter && lowerCaseLetter)
	            return true;
	    }
	    return false;
	}
}
