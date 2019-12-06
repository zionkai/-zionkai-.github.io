/*
 * CIS 4320 GROUP PROJECT
 * VANESSA SEPEDA
 * DOUGLAS SIGMON
 * RICARDO ROSALES
 * ANALAURA LOZANO
 */
package groupProject;
// Importing Decimal Format to format decimal numbers
import java.text.DecimalFormat;
// Importing Exception to indicate the token retrieved does not match the pattern for the expected type
import java.util.InputMismatchException;
// Imported Scanner to read from keyboard
import java.util.Scanner;
// Imported Swing to create the GUI, a dialog box that will request input from user
import javax.swing.JOptionPane;

public class gp {
    public static void main(String[] args) {
    	// Created a scanner to read all types from user's input
        Scanner in = new Scanner(System.in);
        
        // Declaring variables, type boolean, int, and String as well as initializing them
        boolean flag = true;
        int licenseNum = 0;
        int hardNum = 0;
        int subLength = 0;
        String hardChoice = "";
        String licenseChoice = "";
        
        // Using the message dialog box to greet the user and begin taking their order
        JOptionPane.showMessageDialog(null, "Welcome! Let's begin your order.", "Order Form", JOptionPane.INFORMATION_MESSAGE);
        
        // Created a do while loop to execute the block of statements listed below continuosly until the given condition is true
        do {
            // Created a try statement to define a block of code to be tested for errors while executed
            try {
                // Converting the String licenseNum into an integer to be used later when calculating costs
                // Displaying the message dialog box and asking the user to input the amount of licenses they want to purchase
                licenseNum = Integer.parseInt(JOptionPane.showInputDialog(null,"how many licenses would you like to purchase? ","Number of licenses",JOptionPane.QUESTION_MESSAGE));
                
                // Displaying the message dialog box to show the number of licenses the user selected to purchase
                JOptionPane.showMessageDialog(null, "the number of licenses purchased is: " + licenseNum, "Order Form", JOptionPane.INFORMATION_MESSAGE);
                
                // Declaring a string and assigning the value of either Basic or Pro. This String is restricted to only accept the user inputting Basic or Pro.
                String[] licenseOptions = {"Basic","Pro"};
                
                // Displaying the message dialog box and assigning the String licenseChoice to equal the users input to the question below
                licenseChoice = (String)JOptionPane.showInputDialog(null,"Would you like to purchase the Basic License or the Pro License?", "License Type", JOptionPane.QUESTION_MESSAGE,null,licenseOptions,licenseOptions[1]);
                
                // Setting flag to true
                flag = true;
                
                // Declaring a string and assigning it the value of either Yes or No, and also restricting the user's input to Yes or No.
                String[] ynOptions = {"Yes", "No"};
                
                // Displaying the message dialog box and assigning the String hardChoice to equal the users input to the question below
                hardChoice = (String)JOptionPane.showInputDialog(null,"Would you like to add hardware to your purchase?","Hardware Options", JOptionPane.QUESTION_MESSAGE, null,ynOptions,ynOptions[1]);
                
                // Creating an if statement, stating if the users input equals a capitalized or lower cased "yes", then flag will be true 
                if (hardChoice.equalsIgnoreCase("yes")) {
                    flag = true;
                    // Created a while loop stating, while flag is true, it'll go through the loop below
                    
                    while(flag) {
                        // Created a try statement to look for errors in the block of code below, while it is being executed
                        try {
                            // Restricting the variable hardNum to only accept an integer
                            hardNum = Integer.parseInt(JOptionPane.showInputDialog(null, "How many pieces of hardware would you like to purchase?"));
                            // If the user input the correct variable type (int), then we'll exit out of the loop by setting flag to false
                            
                            flag = false;
                          // If the user inputs anything other than an integer, then it'll go through the catch statement below
                        } catch (InputMismatchException var10) {
                            // Displaying the message dialog box and asking the user the question below
                            JOptionPane.showMessageDialog(null,"Please make sure only numbers are entered!","ERROR!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                // Setting flag to true to go through while loop below
                flag = true;
                
                while(flag) {
                    // Created a try statement to look for errors in the block of code below, while it is being executed
                    try {
                        // Created a while loop stating, while flag is true, it'll go through the loop below
                        while(flag) {
                            // Restricting the variable subLength to only accept an integer
                            subLength = Integer.parseInt(JOptionPane.showInputDialog("How many months would you like to subscribe? "));
                            // Created an if statement, stating if the users input equals a capitalized or lower cased "yes", then flag will be true
                            if (hardChoice.equalsIgnoreCase("yes")) {
                            	// Created an if statement, stating is subLength is less than or equal to 11
                                if (subLength <= 11) {
                                	// Displaying the message dialog box and asking the user to input at least 12 month subscription length
                                    JOptionPane.showMessageDialog(null,"You have chosen "+ subLength + " months. Your subscription length must be at least 12 months!","ERROR!",JOptionPane.ERROR_MESSAGE);
                                // Created an else if statement, stating if the subscription length is greater than or equal to 12    
                                } else if (subLength >= 12) {
                                	// Then we will set flag to false to exit out of this loop
                                    flag = false;
                                    }
                                // Created an else if statement, stating if hardChoice equals to upper or lower case "no"
                                } else if (hardChoice.equalsIgnoreCase("no")) {
                                	// Then we will set flag to false and exit out of this loop
                                	flag = false;
                                }
                        }
                        // Setting flag to equal false
                        flag = false;
                        // Created a catch statement to catch of the user inputs anything other than an integer, including special characters, then it'll go through the catch statement below
                        } catch (InputMismatchException var11) {
                        	// Displaying the message dialog box and asking the user the question below
                        	JOptionPane.showMessageDialog(null,"Please make sure only numbers are entered!","ERROR!", JOptionPane.ERROR_MESSAGE);
                        }
                }
                // Setting flag to false
                flag = false;
                // Created a catch statement to catch if the user is inputing a String and trying to convert it to a numeric data type
                } catch (NumberFormatException var12) {
                	// Displaying the message dialog box and asking the user the question below
                	JOptionPane.showMessageDialog(null, "Please make sure only numbers are entered!","Error!",JOptionPane.ERROR_MESSAGE);
                	}
            // Created a while loop that is set to false to exit out of this loop
            } while(flag);
        
        // Calling the methods costCalculation and monthlyYearlyCost in the main method so they can be used throughout the methods below
        double totalCost = costCalculation((double)licenseNum, (double)subLength, hardChoice, hardNum, licenseChoice);
        monthlyYearlyCost(totalCost, (double)subLength, (double)hardNum, hardChoice, licenseNum);
        // Closed the scanner
        in.close();
        }
    
    
    // Created a method type void meaning there is no return value for this method
    // This method will get the calculations for the monthly and yearly costs
    public static void monthlyYearlyCost(double totalCost, double subscriptionLength, double hardInt, String hardChoice, int licenseNum) {
    	// Created DecimalFormat to be used to format numbers, and also formatted the pattern
    	DecimalFormat df = new DecimalFormat(" $###,###.00");
    	// Created a variable type double and initialized it to equal zero
    	
    	double monthlyCost = 0.0;
    	// Reassigned monthlyCost to equal the variables mentioned below
    	
    	monthlyCost = totalCost / subscriptionLength;
    	// Created a variable type double and initialized it to equal zero
    	
    	double yearlyCost = 0.0;
    	// Created a variable type double and initialized it to equal the variables below
    	
    	double years = subscriptionLength / 12.0;
    	
    	double hardwareCost = hardInt * 1000;
    	
    	// Reusing the if statement from the main method, stating if the user inputs a subscription length that's equal to 12 and if the hardChoice answer equals capital or lower case "yes"
    	// Then it'll print out the statements below
    	if (subscriptionLength == 12.0 && hardChoice.equalsIgnoreCase("yes")) {
    		// Reassigned yearlyCost to equal the variables listed below
    		
    		yearlyCost = monthlyCost * subscriptionLength;
    		// Displaying the message dialog box to print the statements and calculations below
    		// Initially the print statement does not have a set value (null)
    		
    		JOptionPane.showMessageDialog(null,"Your monthly cost is:" + df.format(monthlyCost) + " + Tax" + tax(monthlyCost)
    				+ "\nYour monthly cost per license is:" + df.format(monthlyCost / (double)licenseNum) + " + Tax" + tax(monthlyCost / (double)licenseNum)
    				+ "\nYour yearly cost is" + df.format(totalCost) + " + Tax" + tax(totalCost)
    				+ "\nYour yearly cost per license is:" + df.format((yearlyCost - hardwareCost) / (double)licenseNum) + " + Tax" + tax(yearlyCost - hardwareCost/ (double)licenseNum)
    				+ "\nAfter Hardware is paid off you will have a balance of $0.00 for your Software Subscription");
    		
    		// Called the monthlyExpanded method below to print here
    		monthlyExpanded(monthlyCost, monthlyCost, years, subscriptionLength);
    		// Reusing the else if statement from the main method, stating if the user inputs a subscription length that is greater than 12 and hardChoice answer equals capital or lower case "yes"
    		// Then it'll print out the statements and calculations below
    		
    		} else if (subscriptionLength > 12.0 && hardChoice.equalsIgnoreCase("yes")) {
    			// Created a variable type double and initialized it to equal the variables below, which were all called from the main method
    			// yearlyPer was created to calculate the yearly cost per license not including hardware cost
    			double yearlyPer = (totalCost - hardwareCost) * (12.0 / subscriptionLength) / (double)licenseNum;
    			
    			// Created a variable type double and initialized it to equal the variables below
    			// yearlyAll was created to include the hardware cost into the calculations below
    			double yearlyAll = yearlyPer * (double)licenseNum + hardwareCost;
    			
    			// Created a variable type double and initialized it to equal the variables below
    			// This variable will exclude the hardware cost
    			double costAfterHardware = totalCost - yearlyAll;
    			
    			// Displaying the message dialog box to print the statements below
    			// Initially the print statement does not have a set value (null)
    			JOptionPane.showMessageDialog(null,"Your yearly cost per license is:" + df.format(yearlyPer) + " + Tax" + tax(yearlyPer)
    				+ "\nYour yearly cost before hardware is paid off is:" + df.format(yearlyAll) + " + Tax" + tax(yearlyAll)
    				+ "\nYour yearly cost after hardware is paid off is:" + df.format(costAfterHardware) + " + Tax" + tax(costAfterHardware)
    				+ "\nYour monthly cost FOR ALL LICENSE BEFORE hardware is paid off is: " + df.format(yearlyAll / 12.0) + " + Tax" + tax(yearlyAll / 12.0)
    				+ "\nYour monthly cost PER LICENSE before hardware is paid off is: " + df.format(yearlyAll / 12.0 / (double)licenseNum) + " + Tax" + tax(yearlyAll / 12.0 / (double)licenseNum)
    				+ "\nYour monthly cost for ALL LICENSES AFTER hardware is paid off is: " + costAfterHardware / (subscriptionLength - 12.0) + " Tax" + tax(costAfterHardware / (subscriptionLength - 12.0)));
    			
        		// Called the monthlyExpanded method below to print here
    			monthlyExpanded((yearlyAll/12), (costAfterHardware / (subscriptionLength - 12.0)), years, subscriptionLength);
    			
    			// Reusing the else if statement from the main method, stating if the user inputs capital or lower case "no" to the hardChoice question
    			} else if (hardChoice.equalsIgnoreCase("no")) {
    				// Also, if the subscription length is less than 12, it'll print the statements and calculations below
    				if (subscriptionLength < 12.0) {
    					// Displaying the message dialog box to print the statements below
    	    			// Initially the print statement does not have a set value (null)
    					JOptionPane.showMessageDialog(null,"Your monthly cost for all licenses is : $" + df.format(monthlyCost) + " + Tax $" + tax(monthlyCost)
    						+ "\nyour monthly cost per License is: $" + df.format(monthlyCost / (double)licenseNum) + " + Tax $" + tax(monthlyCost / (double)licenseNum));
    					
    		    		// Called the monthlyExpanded method below to print here
    					monthlyExpanded(monthlyCost, monthlyCost, years, subscriptionLength);
    					
    					// Reusing the else if statement, stating if the user input a subscription length equal to 12, it'll print out the statements and calculations below
    					
    					} else if (subscriptionLength == 12.0) {
    						// Displaying the message dialog box to print the statements below
    		    			// Initially the print statement does not have a set value (null)
    						JOptionPane.showMessageDialog(null,"Your monthly cost is : $" + df.format(monthlyCost) + " + Tax $" + tax(monthlyCost)
    							+ "\nYour yearly cost is: $" + df.format(monthlyCost * 12.0) + " + Tax $" + tax(monthlyCost * 12.0)
    							+ "\nYour monthly cost per License is: $" + df.format(monthlyCost / (double)licenseNum) + " + Tax $" + tax(monthlyCost / (double)licenseNum)
    							+ "\nYour yearly cost per license is: $" + df.format(monthlyCost * 12.0 / (double)licenseNum) + " + Tax $" + tax(monthlyCost * 12.0 / (double)licenseNum));
    						
    			    		// Called the monthlyExpanded method below to print here
    						monthlyExpanded(monthlyCost, monthlyCost, years, subscriptionLength);
    						
    						// Reusing the else if statement, stating if the user input a subscription length greater than 12, it'll print out the statements and calculations below
                            } else if (subscriptionLength > 12.0) {
                            	// Reassigned the yearlyCost to equal the variables below
                            	yearlyCost = totalCost / years;
                            	
                            	// Displaying the message dialog box to print the statements below
                    			// Initially the print statement does not have a set value (null)
                            	JOptionPane.showMessageDialog(null,"Your yearly cost is: $" + df.format(yearlyCost) + " + Tax $" + tax(yearlyCost)
                                    + "\nYour yearly cost per license is: $" + df.format(yearlyCost / (double)licenseNum) + " + Tax $" + tax(yearlyCost / (double)licenseNum)
                                    + "\nYour monthly cost is: $" + df.format(monthlyCost) + " + Tax $" + tax(monthlyCost)
                                    + "\nYour monthly cost per license is: $" + df.format(monthlyCost / (double)licenseNum) + " + Tax $" + tax(monthlyCost / (double)licenseNum));
                        		
                            	// Called the monthlyExpanded method below to print here
                            	monthlyExpanded(monthlyCost, monthlyCost, years, subscriptionLength);
                            }
    			}
    }
    
    // Created a method type void meaning there is no return value for this method
    // This method will calculate the monthly expanded costs
    public static void monthlyExpanded(double monthly, double monthlyAfterHard, double years, double subLength) {
    	String[] calendar = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    	DecimalFormat df = new DecimalFormat(" $###,###.00");
    	int pymtNum = 1;
    	yearLoop: 
    		for(int i = 0; i < years ; i++) {
    			for(int j = 0; j < calendar.length; j++) {
    				if(pymtNum < 13) {
    					System.out.println(pymtNum + ". " + calendar[j] + " " + df.format(monthly) + " + Tax " + tax(monthly));
    					pymtNum++;
    					} else if (pymtNum > 12 ) {
    						System.out.println(pymtNum + ". " + calendar[j] + " " + df.format(monthlyAfterHard) + " + Tax " + tax(monthlyAfterHard));
    						pymtNum++;
    						if (pymtNum == subLength + 1) {
    							break yearLoop;
    							}
    						} else {
    							break yearLoop;
    						}
    			}
    		}
    }
    
    // Created this method to return a value, to format numbers and the pattern
    // The method is type String and is formatting the double amounts/costs
    public static String tax(double amount) {
    	DecimalFormat df = new DecimalFormat(" $###,###.00");
    	// Return will equal the double amount * the tax
    	return df.format(amount * 0.0825);
    	}
    
    // Created a method type double to return a value
    // This method is calculating the monthly and yearly costs
    public static double costCalculation(double licenseNum, double subLength, String hardChoice, int hardNum, String licenseChoice) {
    	// Created and initialized two variables type double (discount and result) to equal zero
    	double discount = 0.0;
    	double result = 0.0;
    	int licensePrice;
    	
    	// If the user inputs capital or lower case "basic" for the licenseChoice question then it'll go through conditional statement below
    	if (licenseChoice.equalsIgnoreCase("basic")) {
    		// If the user inputs "basic", licensePrice is equal to 25
    		licensePrice = 25;
    		
    		// If the user doesn't input "basic", then it'll equal to "pro" and the licensePrice is 50
    		} else {
    			licensePrice = 50;
    		}
    	
    	// If the user inputs greater than 10 and less than 100 for the licenseNum
    	if (licenseNum > 10.0 && licenseNum < 100.0) {
    		// The user will receive a 10% discount
    		discount = 0.1;
    		// Else if the user inputs greater than or equal to 100 for the licenseNum
    		} else if (licenseNum >= 100.0) {
    			// The user will receive a 15% discount
    			discount = 0.15;
    		}
    	
    	// If the user inputs a subscription length greater than or equal to 12
    	if (subLength >= 12.0) {
    		// The user will receive a 10% discount
    		discount += 0.1;
    	}
    	// Created and initialized a variable type double to equal the variables below
    	double subCost = (double)licensePrice * subLength * licenseNum;
    	
    	// Result will equal to the variables below
    	result = subCost - discount * subCost;
    	
    	// If the user inputs "yes" to the hardChoice question then it'll return the added result below
    	if (hardChoice.equalsIgnoreCase("yes")) {
    		result += (double)hardNum * 1000.0;
    		}
    	// Returning one or the other results mentioned below
    	return result;
    }
}