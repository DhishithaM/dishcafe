//necessary imports for file i/o
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * CSS 142 Section A Special Final Project: DishCafeOrderLog 
 * Dhishitha Madhavan
 */

public class DishCafeOrderLog {
    /*
     * Read's dishCafeOrder.txt file and prints the contents of that file to the output window if file can be located
     * @return nothing is void a void type
     */
    public static void printFromFile() {
        Scanner inputStream = null; //intialize input stream
        try {
            inputStream = new Scanner(new FileInputStream("dishCafeOrder.txt")); //set stream to dishCafeOrder.txt file
            while(inputStream.hasNext()) {//read file while characters are left
                System.out.println(inputStream.nextLine()); //print contents of file to output window
            }
            inputStream.close(); //close file stream once done
        } catch (FileNotFoundException f) {
            System.out.println("File does not exist."); //print file error occured
        }
    }
 
    /*
     * Write's to dishCafeOrder.txt file the contents of the user order and appends not replaces pfor previous orders if file can be properly opened
     * @return nothing is void a void type
     */
    public static void saveOrderToFile(String orderInfo) {
        PrintWriter outStream = null; //intialize output stream
        try {
            outStream = new PrintWriter(new FileOutputStream("dishCafeOrder.txt", true), true); //append outstream
            outStream.println(orderInfo); //printing parameter string(user order) to file
            outStream.close(); //close output stream once done
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file"); //print file error occured
            System.exit(0); //exit program
        }
    }
   
    /*
     * Reset's all previous orders so next user can have a clean slate
     * @return nothing is void a void type
     */
    public static void resetFile() {
        PrintWriter outStream = null; //intialize output stream
        try {
            outStream = new PrintWriter(new FileOutputStream("dishCafeOrder.txt")); //set outstream to dishCafeOrder.txt
            outStream.close(); //close outstream
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file"); //print file error occured
            System.exit(0); //exit program
        }
    }       
}
