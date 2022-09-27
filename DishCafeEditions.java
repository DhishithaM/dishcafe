//necessary imports for file i/o
import java.util.Scanner;
/**
 * CSS 142 Section A Special Final Project: DishCafeEditions
 * Dhishitha Madhavan
 */
public class DishCafeEditions
{
    //edition menu arrays
    private String[] milkMenu = new String [] {"almond", "coconut", "oat", "soy", "half and half", "lactose-free","non-fat", "whole", "2%"};
    private String[] sugarMenu = new String [] {"white", "raw", "brown"};
    private String[] fruitMenu = new String [] {"lemon slice", "lime slice"};
    private String[] sizeMenu = new String [] {"small (8 oz)", "medium (12oz)", "regular (16oz)", "large (20 oz)"};
    private String[] temperatureMenu = new String [] {"cold", "medium", "hot", "extra hot"};

    /*
     * Prints the options of size's available for user to chose from
     * @return nothing is a void type
     */
    public void printSizeMenu(){
        System.out.println("Available size options:"); //label
        for (int i = 0; i < sizeMenu.length; i++){
            if (i == 0){ //first word special
                System.out.print("* " + sizeMenu[i] + ", "); //star in front
            }else if (i == sizeMenu.length - 1){ //last word special
                System.out.println(sizeMenu[i] + " \n"); //no comma and new line
            } else { //other words
                System.out.print(sizeMenu[i] + ", "); //comma's inbetween
            }
        }
    }   

    /*
     * Prints the options of milk's available for user to chose from
     * @return nothing is a void type
     */
    public void printMilkMenu(){
        System.out.println("Available milk options:"); //label
        for (int i = 0; i < milkMenu.length; i++){
            if (i == 0){
                System.out.print("* " + milkMenu[i] + ", "); //star in front
            }else if (i == milkMenu.length - 1){
                System.out.println(milkMenu[i] + " \n"); //no comma and new line
            } else {
                System.out.print(milkMenu[i] + ", "); //comma's inbetween
            }
        }
    }   

    /*
     * Prints the options of sugar's available for user to chose from
     * @return nothing is a void type
     */
    public void printSugarMenu(){
        System.out.println("Available sugar options:"); //label
        for (int i = 0; i < sugarMenu.length; i++){
            if (i == 0){
                System.out.print("*sugar: " + sugarMenu[i] + ", "); //star in front
            }else if (i == sugarMenu.length - 1){
                System.out.println(sugarMenu[i] + " \n"); //no comma and new line
            } else {
                System.out.print(sugarMenu[i] + ", "); //comma's inbetween
            }
        }
    }   

    /*
     * Prints the options of temperature's available for user to chose from
     * @return nothing is a void type
     */
    public void printTemperatureMenu(){
        System.out.println("Available temperature options:"); //label
        for (int i = 0; i < temperatureMenu.length; i++){
            if (i == 0){
                System.out.print("* " + temperatureMenu[i] + ", "); //star in front
            }else if (i == temperatureMenu.length - 1){
                System.out.println(temperatureMenu[i] + " \n"); //no comma and new line
            } else {
                System.out.print(temperatureMenu[i] + ", "); //comma's inbetween
            }
        }
    }   

    /*
     * Prints the options of fruit available for user to chose from
     * @return nothing is a void type
     */
    public void printFruitMenu(){
        System.out.println("Available fruit options:"); //label for fruit menu
        for (int i = 0; i < fruitMenu.length; i++){
            if (i == 0){
                System.out.print("*fruit: " + fruitMenu[i] + ", "); //star in front
            }else if (i == fruitMenu.length - 1){
                System.out.println(fruitMenu[i] + " \n"); //no comma and new line
            } else {
                System.out.print(fruitMenu[i] + ", "); //comma's inbetween
            }
        }
    }

    /*
     * Get user's fruit choice using scanner until they make a valid fruit selection
     * @return string of user fruit choice
     */
    public String userFruitChoice (){
        Scanner userInputMenu = new Scanner(System.in); //declare/intialize scanner
        String userChoice = ""; //intialize string for user input
        do{
            System.out.println("Would you like lemon or lime? If none type no fruit"); //prompt user
            userChoice = userInputMenu.nextLine().toLowerCase(); //set user choice to next line and lower case to compare for array and if statement         
            switch (userChoice){
                case "lemon": 
                case "lime": 
                case "no fruit":
                    System.out.println("Nice!\n"); //give user feedback
                    return userChoice + " "; //no breaks because all cases prior will want this same action of returning the user choice with space and breaking out of switch case and loop
                default: //userchoice = any other answer
                    System.out.println("I do not recognize your choice, please type in lemon or lime!"); //give user feedback
                    break; //exit out of switch case
            }
        }while(true);//will continue to loop switch until userchoice is lemon/lime/no fruit
    }

    /*
     * Get user's temperature choice using scanner until they make a valid temperature selection
     * @return string of user temperature choice
     */
    public String userTemperatureChoice (){
        Scanner userInputMenu = new Scanner(System.in); //declare/intialize scanner
        String userChoice = ""; //intialize string for user input       
        do{
            System.out.println("What temperature would you like for your drink?"); //prompt user
            userChoice = userInputMenu.nextLine().toLowerCase(); //set user choice to next line and lower case to compare for array
            for(int i = 0; i < temperatureMenu.length; i++){
                if (temperatureMenu[i].equals(userChoice)){ //if an array choice matches user choice
                    System.out.println("Awesome!\n"); //give user feedback
                    return userChoice + " "; //add space and return as sugar order choice  
                }
            }
            System.out.println("I do not recognize your choice, please try again!"); //give user feedback
        } while(true); //loop until valid selection is made            
    }

    /*
     * Get user's sugar choice using scanner until they make a valid sugar selection
     * @return string of user sugar choice
     */
    public String userSugarChoice (){
        Scanner userInputMenu = new Scanner(System.in); //declare/intialize scanner
        String userChoice = ""; //intialize string for user input       
        do{
            System.out.println("What type of sugar would you like for your drink? If none type no sugar.");  //prompt user
            userChoice = userInputMenu.nextLine().toLowerCase(); //set user choice to next line and lower case to compare for array and if statement       
            if (userChoice.equals("no sugar")){ //not in array so seperate
                System.out.println("Rad!\n"); //give user feedback
                return userChoice + " "; //add space and return as sugar order choice               
            }
            for(int i = 0; i < sugarMenu.length; i++){
                if (sugarMenu[i].equals(userChoice)){ //if an array choice matches user choice                    
                    System.out.println("Rad!\n"); //give user feedback
                    return userChoice + " "; //add space for order;
                } 
            }
            System.out.println("I do not recognize your choice, please try again!"); //give user feedback
        } while(true); //loop until valid selection is made       
    }

    /*
     * Get user's milk choice using scanner until they make a valid milk selection
     * @return string of user milk choice
     */
    public String userMilkChoice (){
        Scanner userInputMenu = new Scanner(System.in); //declare/intialize scanner
        String userChoice = ""; //intialize string for user input        
        do{
            System.out.println("What type of milk would you like for your drink? If none please type no milk."); //prompt user
            userChoice = userInputMenu.nextLine().toLowerCase(); //set user choice to next line and lower case to compare for array and if statement
            if (userChoice.equals("no milk")){                
                System.out.println("Tasty!\n"); //give user feedback
                return userChoice + " "; //add space and return as milk order choice
            }

            for(int i = 0; i < milkMenu.length; i++){
                if (milkMenu[i].equals(userChoice)){ //check milk array for if it matches user choice                
                    System.out.println("Tasty!\n"); //give user feedback
                    return userChoice + " "; //add space and return as milk order choice
                }
            }
            System.out.println("I do not recognize your choice, please try again!"); //give user feedback  for if choice is not recognized         
        } while(true); //loop until valid selection is made        
    }
}