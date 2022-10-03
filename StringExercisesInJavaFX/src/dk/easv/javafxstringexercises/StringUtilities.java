package dk.easv.javafxstringexercises;

//Java imports (dependencies)
import java.util.Scanner;

/**
 * @author smsj
 */
public class StringUtilities
{
    /**
     * Default empty constructor
     */
    public StringUtilities() {
        //Just empty....
    }


    /**
     * Adapted for JavaFX
     * Surrounds the input with < and >
     */
    public String addTagsToText(String input) {

        //Modify the input
        String output = "<" + input + ">";

        return output;
    }



    /**
     * Console Version
     * Surrounds the input with < and >
     */
    /*
    public void addTagsToText() {
        //Create scanner object to get input from user
        Scanner scanner = new Scanner(System.in);

        //Ask user to enter a string
        System.out.println("Enter a string:");

        //Get input from user
        String input = scanner.next();

        //Modify the input
        String output = "<" + input + ">";

        //Write the result to the console
        System.out.println(output);
    }
    */
}
