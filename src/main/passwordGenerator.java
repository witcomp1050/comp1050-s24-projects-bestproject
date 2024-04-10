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
		StringBuilder password = new StringBuilder();
		// creates randomness
		Random random = new Random();
		
		// creates a string consisting of components user selects
		if (wantsUpperCase) {
            allChars += upperCase;
            password.append(upperCase.charAt(random.nextInt(upperCase.length())));
        }
        if (wantsLowerCase) {
            allChars += lowerCase;
            password.append(lowerCase.charAt(random.nextInt(lowerCase.length())));
        }           
        if (wantsNumbers) {
            allChars += numbers;
            password.append(numbers.charAt(random.nextInt(numbers.length())));
        }           
        if (wantsSpecialCharacters) {
            allChars += specialCharacters;
            password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));
        }

        // Add remaining characters based on the length
        for (int i = password.length(); i < length; i++) {
            int randomIndex = random.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }
        
        // Shuffle the generated password for randomness
        for (int i = password.length() - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = password.charAt(index);
            password.setCharAt(index, password.charAt(i));
            password.setCharAt(i, temp);
        }

        // returns users random password in string form
        return password.toString();
	
	}
}
