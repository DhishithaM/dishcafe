//necessary imports for file i/o
import java.util.Scanner;
/**
 * CSS 142 Section A Special Final Project: DishCafeOrder 
 * Dhishitha Madhavan
 */
public class DishCafeOrder
{
    //declare instance variables
    DishCafeMenu menu;
    DishCafeEditions editions;
    
     /*
     * Used to intialize instance variables
     * @return nothing is a constructor
     */ 
    public DishCafeOrder(DishCafeMenu menu, DishCafeEditions editions){
        this.menu = menu; //intialize menu 
        this.editions = editions; //intialize editions
    }

    /*
     * create user order of full drink through calling methods and creating final string of full order
     * @return String of full user order 
     */
    public String createUserOrder(){
        //declare strings
        String teaChoice = "";
        String fruitChoice = "";
        String coffeeChoice = "";
        String foamChoice = "";
        String espressoChoice = "";
        String orderInfo = "";
        //order strings
        String line = "****************************************************************";
        String orderText = " Your order details:";
        orderInfo = String.format("%s%n%s%n%s%n",line,orderText,line); //space and format lines and order details

        menu.printMenu(); //print menu

        //set drink type to userdrinktype method
        String drinkType = userDrinkType();
        if(drinkType.equals("tea ")){ //if user drink type is tea
            System.out.println(menu.getTeaMenu()); //print tea menu
            teaChoice = menu.userTeaChoice(); //set tea choice to userteachoice method
            editions.printFruitMenu(); //print fruit menu
            fruitChoice = editions.userFruitChoice();//set fruit choice to userfruitchoice method
            orderInfo = String.format("%s Drink: %s%n Tea Choice: %s%n Fruit Choice: %s%n", 
                orderInfo,drinkType,teaChoice,fruitChoice);
        } else{ //if user drink type is coffee
            System.out.println(menu.getCoffeeMenu()); //print coffee menu
            coffeeChoice = menu.userCoffeeChoice(); //set coffee choice to usercoffeechoice method
            foamChoice = userFoamChoice(); //set foam choice to userfoamchoice method
            espressoChoice = userEspressoShotSize(); //set espresso choice to userespressochoice method
            orderInfo = String.format("%s%n Drink: %s%n Coffee Choice: %s%n Foam Choice: %s%n Shot Size: %s%n", 
                orderInfo,drinkType,coffeeChoice,foamChoice,espressoChoice);
        }

        editions.printSizeMenu(); //print size menu
        String sizeChoice = userSizeChoice(); //set size choice to usersizechoice method

        editions.printMilkMenu(); //print milk menu
        String milkChoice = editions.userMilkChoice(); //set milk choice to usermilkchoice method

        editions.printSugarMenu(); //print sugar menu
        String sugarChoice = editions.userSugarChoice(); //set sugar choice to usersugarchoice method

        editions.printTemperatureMenu(); //print temp menu
        String temperatureChoice = editions.userTemperatureChoice(); //set temp choice to usertempchoice method

        orderInfo = String.format("%s Size Choice: %s%n Milk Choice: %s%n Sugar Choice: %s%n Temperature Choice: %s%n%s%n",
        orderInfo,sizeChoice,milkChoice,sugarChoice,temperatureChoice, line); //format user order choices
        return orderInfo; //return full user order
    }

    /*
     * Get user's choice to either confirm or cancel order using scanner until they make a valid order selection
     * @return boolean of user confirm or cancel choice
     */
    public boolean confirmOrder(String orderInfo) {
        Scanner userOrder = new Scanner(System.in); //intialize scanner
        String userChoice = ""; //intialize string for user input    
        System.out.printf("Here is details of your order:%n%n%s%n%n", orderInfo); //give user order details
        do{
            System.out.println("Please say yes or no to confirm/cancel this order."); //prompt user
            userChoice = userOrder.nextLine().toLowerCase(); //set user choice to next line and lower case for switch case       
            if(userChoice.equals("yes")){ //if user types yes
                return true;
            } else if (userChoice.equals("no")){ //if user types no
                return false;
            } else { 
                System.out.println("I do not recognize your choice, please type in yes or no!"); //give user feedback
            }      
        } while (true); //loop until valid valid selection is made    
    }

    /*
     * Get user's drink choice using scanner until they make a valid drink selection
     * @return string of user drink choice
     */
    private String userDrinkType(){
        Scanner userInputMenu = new Scanner(System.in); //declare/intialize scanner
        String userChoice = ""; //intialize string for user input
        do{
            System.out.println("Would you like coffee or tea?"); //prompt user
            userChoice = userInputMenu.nextLine().toLowerCase(); //set user choice to next line and lower case for switch case           
            switch (userChoice){
                case "coffee": 
                case "tea": 
                    System.out.println("Great choice!\n"); //give user feedback
                    return userChoice + " "; //no breaks because all cases prior will want this same action of returning the user choice with space and breaking out of switch case and loop
                default: //userchoice = any other answer
                    System.out.println("I do not recognize your choice, please type in tea or coffee!"); //give user feedback
                    break; //exits out of switch               
            }
        }while(true); //loop until valid selection is made   
    }

    /*
     * Get user's size choice using scanner until they make a valid size selection
     * @return string of user size choice
     */
    private String userSizeChoice (){
        Scanner userInputMenu = new Scanner(System.in); //declare/intialize scanner
        String userChoice = "";  //intialize string for user input        
        do{
            System.out.println("What size would you like for your drink? Please type small, medium, regular or large."); //prompt user
            userChoice = userInputMenu.nextLine().toLowerCase(); //set user choice to next line and lower case for switch case   
            switch (userChoice){
                case "small":                    
                case "medium": 
                case "regular": 
                case "large":                    
                    System.out.println("Lovely!\n"); //give user feedback
                    return userChoice + " "; //no breaks because all cases prior will want this same action of returning the user choice with space and breaking out of switch case and loop
                default: //userchoice = any other answer
                    System.out.println("I do not recognize your choice, please try again!"); //give user feedback                    
                    break; //exits out of switch              
            }
        }while(true); //loop until valid selection is made           
    }

     /*
     * Get user's foam choice using scanner until they make a valid foam selection
     * @return string of user foam choice
     */
    private String userFoamChoice(){
        Scanner userInputMenu = new Scanner(System.in); //declare/intialize scanner
        String userChoice = ""; //intialize string for user input        
        do{
            System.out.println("Would you like foam or no foam?"); //prompt user
            userChoice = userInputMenu.nextLine().toLowerCase(); //set user choice to next line and lower case for switch case        
            switch (userChoice){
                case "foam": 
                case "no foam": 
                    System.out.println("Cool!\n");
                    return userChoice + " "; //return selection
                default: //userchoice = any other answer
                    System.out.println("I do not recognize your choice, please type in foam or no foam!"); //prompt user for valid answer                    
                    break; //exits out of switch             
            }
        }while(true); //loop until valid selection is made   
    }

    /*
     * Get user's espresso choice using scanner until they make a valid espresso selection
     * @return string of user espresso choice
     */
    private String userEspressoShotSize(){
        Scanner userInputMenu = new Scanner(System.in); //declare/intialize scanner
        int userChoice = 0; //intialize number of coffee shots for user input
        do{
            System.out.println("How many expresso shots would you like? (in digits, 20 is max)");
            userChoice = userInputMenu.nextInt(); //reads num value for switch menu
            if (userChoice < 0 || userChoice > 20){ //bounds for espresso shots
                System.out.println("Sorry that is not a valid amount of espresso shots!"); //give user feedback
                userChoice = userInputMenu.nextInt(); //reads user num value
            } else {
                    System.out.println("That's valid!\n"); //give user feedback
                    return userChoice + " shots "; //add space and shots after and return as espresso choice
                }
        } while (true); //loop until valid selection is made   
    }
}