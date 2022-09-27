//necessary imports for file i/o
import java.util.Scanner;
/**
 * CSS 142 Section A Special Final Project: DishCafeMenu 
 * Dhishitha Madhavan
 */
public class DishCafeMenu
{
    //menu arrays
    private static String[] coffeeMenu = new String [] {"americano", "espresso (short/long)", "latte", "mocha", "vanilla", "cappuccino"};
    private static String[] teaMenu = new String [] {"earl grey", "jasmine", "green", "black","chai"};

    /*
     * Used to call options of coffee available for user to chose from when printing menu design
     * @return String of formatted coffee choices
     */ 
    public String getCoffeeMenu(){
        String coffeeChoices = "*Coffee: "; //beginning label
        for (int i = 0; i < coffeeMenu.length; i++){
            if (i == coffeeMenu.length - 1){
                coffeeChoices += coffeeMenu[i] + " \n"; //no comma at the end
            } else {
                coffeeChoices += coffeeMenu[i] + ", "; //comma inbetween
            }
        }
        return coffeeChoices; //print out full string
    }

    /*
     * Used to call options of tea available for user to chose from when printing menu design
     * @return String of formatted tea choices
     */   
    public String getTeaMenu(){
        String teaChoices = "*Tea: "; //beginning label
        for (int i = 0; i < teaMenu.length; i++){
            if (i == teaMenu.length - 1){
                teaChoices += teaMenu[i] + " \n"; //no comma at the end
            } else {
                teaChoices += teaMenu[i] + ", "; //comma inbetween
            }
        }
        return teaChoices; //print out full string
    }

    /*
     * Prints the menu of coffee and tea choices from dishCafe for user's to choose from
     * @return nothing is a void type
     */ 
    public void printMenu()
    {
        String coffee = getCoffeeMenu(); //set string to coffee menu
        String tea = getTeaMenu(); //set string to tea menu
        String coffeeFormat = coffee + "%" + (76-coffee.length()) + "s%n"; //format coffee length
        String teaFormat = tea + "%" + (76+2-tea.length()) + "s%n"; //format tea length
        String line = "******************************************************************************"; //line of stars
        System.out.printf("%n%n%s%n", line); //print line
        System.out.printf("*%77s%n", "          dish cafe menu:                                *"); //print dish cafe
        System.out.printf(coffeeFormat,"*"); //print out formatted coffee
        System.out.printf(teaFormat, "*"); //print out formatted tea
        System.out.printf("%s%n%n",line); //print out line
    }

    /*
     * Prints the options of coffee available for user to chose from
     * @return nothing is a void type
     */    
    public void printCoffeeMenu (){
        String coffeeChoices = "*coffee: "; //beginning label
        for (int i = 0; i < coffeeMenu.length; i++){
            if (i == coffeeMenu.length - 1){
                coffeeChoices += coffeeMenu[i] + " "; //no comma at the end
            } else {
                coffeeChoices += coffeeMenu[i] + ", "; //comma inbetween
            }
        }
        System.out.println(coffeeChoices); //print out full string
    }

    /*
     * Prints the options of tea available for user to chose from
     * @return nothing is a void type
     */
    public void printTeaMenu (){
        String teaChoices = "*tea: "; //beginning label
        for (int i = 0; i < teaMenu.length; i++){
            if (i == teaMenu.length - 1){
                teaChoices += teaMenu[i] + " "; //no comma at the end
            } else {
                teaChoices += teaMenu[i] + ", "; //comma inbetween
            }
        }
        System.out.println(teaChoices); //print out full string
    }
    
    

    /*
     * Get user's tea choice if tea is chosen using scanner until they make a valid tea type selection
     * @return string of user tea type choice
     */
    public String userTeaChoice (){
        Scanner userInputMenu = new Scanner(System.in); //declare/intialize scanner
        String userChoice = ""; //intialize string for user input        
        do{
            System.out.println("What type of tea would you like?"); //prompt user
            userChoice = userInputMenu.nextLine().toLowerCase(); //set user choice to next line and lower case to compare for array          
            for(int i = 0; i < teaMenu.length; i++){
                if (teaMenu[i].equals(userChoice)){ //check if user choice matches an array choices
                    System.out.println("Delightful!\n"); //give user feedback
                    return userChoice + " "; //return user tea choice
                }
            }
            System.out.println("I do not recognize your choice, please try again!"); //give user feedback
        } while(true); //loop until valid selection is made 
    }

    /*
     * Get user's coffee choice if espresso is chosen using scanner until they make a valid coffee type selection
     * @return string of user coffee type choice
     */
    public String userCoffeeChoice (){
        Scanner userInputMenu = new Scanner(System.in); //declare/intialize scanner
        String userChoice = ""; //intialize string for user input       
        do{
            System.out.println("What type of coffee would you like?"); //prompt user
            userChoice = userInputMenu.nextLine().toLowerCase(); //set user choice to next line and lower case to compare for array and if statement                
            for(int i = 0; i < coffeeMenu.length; i++){                 
                if(coffeeMenu[i].equals(userChoice) || userChoice.equals("espresso")){ //check array and for word espresso since menu has short or long in parantheses                  
                    if (userChoice.equals("espresso")){ //ask special question for espresso
                        System.out.println("Marvelous!\n"); //give user feedback 
                        return userChoice + " " + userEspressoChoice() + " "; //return coffee choice and espresso type if chosen with spaces                    
                    }
                    else {
                        System.out.println("Marvelous!\n"); //give user feedback 
                        return userChoice + " "; //return user coffee choice
                    }
                }
            }
            System.out.println("I do not recognize your choice, please try again!"); //give user feedback
        } while(true); //loop until valid selection is made  
    }

    /*
     * Get user's short or long choice if espresso is chosen using scanner until they make a valid espresso type selection
     * @return string of user espresso type choice
     */
    public String userEspressoChoice (){
        Scanner userInputMenu = new Scanner(System.in); //declare/intialize scanner
        String userChoice = ""; //intialize string for user input
        do{
            System.out.println("Short or long?"); //prompt user special question for espresso        
            userChoice = userInputMenu.nextLine().toLowerCase(); //set user choice to next line and lower case to compare for if statement            
            if (userChoice.equals("short") || userChoice.equals("long")){ //available correct answer choices        
                System.out.println("Sweet!\n"); //give user feedback                
                return userChoice + " "; ////add space and return as espresso type order choice
            }
            System.out.println("I do not recognize your choice, please try again!"); //give user feedback
        } while (true); //loop until valid selection is made         
    }    
}