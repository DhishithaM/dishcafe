//necessary imports for file i/o
import java.util.*;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
/**
 * CSS 142 Section A Special Final Project: DishCafe 
 * Dhishitha Madhavan
 */
public class DishCafe
{
    public static void main (String [] Args){
        DishCafeMenu menu = new DishCafeMenu(); //object copy of menu class
        DishCafeEditions editions = new DishCafeEditions(); //object copy of menu editions class
        DishCafeOrder order = new DishCafeOrder(menu, editions); //object cafe order of menu class
        DishCafeOrderLog.resetFile();
        boolean nextOrder = true; //intialize next order       
        do{
            String orderInfo = order.createUserOrder(); //call method supplying classes
            if(order.confirmOrder(orderInfo)){//if order confirmed
                DishCafeOrderLog.saveOrderToFile(orderInfo); //print user order to file
            }

            System.out.println("Would you like another drink?"); //prompt user
            Scanner userOrder = new Scanner(System.in); //intialize scanner
            String choice = ""; //intialize choice
            choice = userOrder.nextLine().toLowerCase(); //set user choice to next line and lower case to compare in if statement           
            if(choice.equals("yes")){ //if user wants another drink
                nextOrder = true; //keep next order true
            } else if (choice.equals("no")){ //if user does not want another drink
                nextOrder = false; //set next order to false
            } else {
                System.out.println("I do not recognize your choice, please type in yes or no!"); //give user feedback
            }
        } while(nextOrder == true); //loop until valid selection is made 

        DishCafeOrderLog.printFromFile(); //read file and print to output window user drink order
        System.out.println("Thank you for visiting dish's cafe! Please come again!"); //give parting message to user

        /*
         * coffee test cases
         * coffee espresso short no foam 1 small oat no sugar extra hot (case given in description)
         * coffee espresso long no foam 2 large 2% no sugar extra hot (case given in description)
         * coffee latte no foam 2 large no milk no sugar extra hot (case given in description)
         * coffee vanilla no foam 0 medium lactose-free brown medium
         * 
         * Tea test cases:
         * tea green no fruit small no milk no sugar cold (case given in description)
         * tea black lemon medium half and half white medium (case given in description)
         * tea jasmine lime regular non-fat brown cold
         * tea chai no fruit large almond milk raw hot
         * 
         * COFFEE CASES
         * ****************************************************************
        Your order details
         ****************************************************************

        Drink: coffee 
        Coffee Choice: espresso short  
        Foam Choice: no foam 
        Shot Size: 1 shots 
        Size Choice: small 
        Milk Choice: oat 
        Sugar Choice: no sugar 
        Temperature Choice: extra hot 
         ****************************************************************

         ****************************************************************
        Your order details
         ****************************************************************

        Drink: coffee 
        Coffee Choice: espresso long  
        Foam Choice: no foam 
        Shot Size: 2 shots 
        Size Choice: large 
        Milk Choice: 2% 
        Sugar Choice: no sugar 
        Temperature Choice: extra hot 
         ****************************************************************

         ****************************************************************
        Your order details
         ****************************************************************

        Drink: coffee 
        Coffee Choice: latte 
        Foam Choice: no foam 
        Shot Size: 2 shots 
        Size Choice: large 
        Milk Choice: no milk 
        Sugar Choice: no sugar 
        Temperature Choice: extra hot 
         ****************************************************************

         ****************************************************************
        Your order details
         ****************************************************************

        Drink: coffee 
        Coffee Choice: vanilla 
        Foam Choice: no foam 
        Shot Size: 0 shots 
        Size Choice: medium 
        Milk Choice: lactose-free 
        Sugar Choice: brown 
        Temperature Choice: medium 
         ****************************************************************
        Thank you for visiting dish's cafe! Please come again!

        TEA CASES
         ****************************************************************
        Your order details
         ****************************************************************
        Drink: tea 
        Tea Choice: green 
        Fruit Choice: no fruit 
        Size Choice: small 
        Milk Choice: no milk 
        Sugar Choice: no sugar 
        Temperature Choice: cold 
         ****************************************************************

         ****************************************************************
        Your order details
         ****************************************************************
        Drink: tea 
        Tea Choice: black 
        Fruit Choice: lemon 
        Size Choice: medium 
        Milk Choice: half and half 
        Sugar Choice: white 
        Temperature Choice: medium 
         ****************************************************************

         ****************************************************************
        Your order details
         ****************************************************************
        Drink: tea 
        Tea Choice: jasmine 
        Fruit Choice: lime 
        Size Choice: regular 
        Milk Choice: non-fat 
        Sugar Choice: brown 
        Temperature Choice: cold 
         ****************************************************************

         ****************************************************************
        Your order details
         ****************************************************************
        Drink: tea 
        Tea Choice: chai 
        Fruit Choice: no fruit 
        Size Choice: large 
        Milk Choice: almond 
        Sugar Choice: raw 
        Temperature Choice: hot 
         ****************************************************************
        Thank you for visiting dish's cafe! Please come again!
         */
    }
}