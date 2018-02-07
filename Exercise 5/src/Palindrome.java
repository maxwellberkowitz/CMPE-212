import java.util.Scanner;

public class Palindrome {
	
	 // massage strips all non-letter characters from the String argument 
	 // and makes the String all lower case.  The method returns the 
	 // resulting String. 
	 static String massage (String s) { 
		 s.toLowerCase();
		 s.trim();
		 String result = "";
		 for(int i = 0; i < s.length(); i++) {
			 if(Character.isLetter(s.charAt(i)))
				 result = result + s.charAt(i);
		 }
		 return result;
	 } // end massage 
	  
	 // match returns true if the first and last letters in the String argument 
	 // are the same. 
	 static boolean match (String s) { 
		 s.trim();
		 if(s.charAt(0) == s.charAt(s.length()-1))
			 return true;
		 else
			 return false;
	 } // end match 
	  
	 // strip removes the first and last letters of the String argument, returning 
	 // the resulting String. 
	 static String strip (String s) { 
	  s.trim();
	  if(s.length()<2)
		  return s;
	  return s.substring(1,s.length()-1);
	 } // end strip 
	  
	 // test returns true if the String argument is a palindrome, false otherwise. 
	 // test uses the other methods defined above. 
	 static boolean test (String s) { 
		 s = massage(s);
	        do {
	            if (match(s)) {
	                s = strip(s);
	            } else {
	                return false;
	            }
	        } while (s.length() > 1);
	        return true;
	 } // end test 
	  
	 // The main method obtains the string to test from the user, calls the test 
	 // method, and displays the result to the user. 

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.print("Enter string to test: ");
        String testString = input.nextLine();
        input.close();
        if (test(testString)) {
            System.out.println("Is a palindrome.");
        } else {
            System.out.println("Is not a palindrome.");
        }
	}

}
