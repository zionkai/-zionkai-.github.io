// Importing the Scanner to allow to read from keyboard
import java.util.Scanner;

// Naming the class Project1
public class Project1 
{
    // This is the main method that is executed first.
    public static void main(String args[])
    {
      // Creating the scanner to read all types.
      Scanner myObj = new Scanner(System.in);
      
      // Declaring the strings that will later be assigned the user's input
      String firstName;
      String lastName;
      String gender;
      String dob;
      String age; 
      String phoneNumber;
      String gpa;

      
      // Creating the User Registration Form Program
      // Assigning the string values by reading the users input from the scanner
      System.out.println("1. Enter First Name"); 
      firstName = myObj.nextLine();
      
      System.out.println("2. Enter Last Name"); 
      lastName = myObj.nextLine();
      
      System.out.println("3. Enter Gender");
      gender = myObj.nextLine();
      
      System.out.println("4. Enter Date of Birth (MM/DD/YYYY)");
      dob = myObj.nextLine();
      
      System.out.println("5. Enter Age");
      age = myObj.nextLine();
      
      System.out.println("6. Enter Phone Number (XXX-XXX-XXXX)");
      phoneNumber = myObj.nextLine();
      
      System.out.println("7. Enter GPA");
      gpa = myObj.nextLine();
      
      // Creating the Password Program
      // Using the charAt method to to rename each string to only recall the first character of each input
      char ofname = firstChar(firstName);
      char olname = firstChar(lastName);
      char ogend = firstChar(gender);
      char odob = firstChar(dob);
      char oage = firstChar(age);
      char ophnumber = firstChar(phoneNumber);
      char ogpa = firstChar(gpa);
      
      // Creating the print out order and using charAt method 
      // To concatenate only first character of each input
      System.out.println("Password: " + ofname + olname + ogend + odob + oage + ophnumber + ogpa + "\n");
      
      // Creating the Program to Calculate days alive in years, months, weeks, days, hours, minutes
      // Assigned variables as integers to be able to multiply by another integer
      // In Line 63 converted the String age into an integer to make all other equations feasible
      int days = Integer.parseInt (age);
      // Days equals the users input
      // Days is then multiplied by each variable
      int years = days*12;
      int months = days*52;
      int weeks = days*365;
      int hours = days*(365*24);
      int minutes = days*(365*24*60);
      long seconds = days*(365*24*60*60);
      
      // Designing the print out
      System.out.println("Wow " + firstName + "! You are " + days + " years old, that is " + years +
      " months, or " + months + " weeks, or " + weeks + " days, or " + hours + 
      " hours, or " + minutes + " minutes, or " + seconds + " seconds!");
        
      // Closing the scanner.
      myObj.close();
      
    }  
    
    // Method to Create Password by collecting the first character of each string
    public static char firstChar(String wrd)
    {
        // Each string begins with 0
        char first = wrd.charAt(0); 
        // Asking the program to return only the first character
		return first;
    }
}
