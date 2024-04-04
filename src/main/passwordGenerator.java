package main;

import java.util.Random;

public class passwordGenerator {
	
	
	public static String generatePassword(boolean wantsUpperCase, boolean wantsLowerCase, 
	boolean wantsNumbers, boolean wantsSpecialCharacters, int length) {
		
		// declares all possible characters in password
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String specialCharacters = "!@#$%^&*?";
		String allChars = "";
		
		// creates randomness
		Random random = new Random();
		
		// creates a string consisting of components user selects
		if (wantsUpperCase) {
			allChars += upperCase;
		}
		if (wantsLowerCase) {
			allChars += lowerCase;
		}			
		if (wantsNumbers) {
			allChars += numbers;
		}			
		if (wantsSpecialCharacters) {
			allChars += specialCharacters;
		}
		
		// builds the password string using randomness
		StringBuilder password = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
		}
		
		// returns users random password in string form
		return password.toString();
	
	}
}
