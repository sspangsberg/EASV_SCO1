package dk.easv.javafxstringexercises.bll;

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

    public void addTagsToTextConsole() {
        // Create scanner object to get input from user
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter a string
        System.out.println("Enter a string:");

        // Get input from user
        String input = scanner.next();

        // Modify the input
        String output = "<" + input + ">";

        // Write the result to the console
        System.out.println(output);
    }



    /**
     * Adapted for JavaFX
     * Surrounds the input with < and >
     */
    public int countCharacters(String input) {
        return input.length();
    }


    /**
     * Adds a @ to the input string
     * @param input
     * @return
     */
    public String addAtSign(String input)
    {
        String output = "";
        for (int i = 0; i < input.length(); i++)
        {
            if (i < input.length() - 1)
            {
                output = output + input.charAt(i) + "@";
            }
            else
            {
                output = output + input.charAt(i);
            }
        }

        return output;
    }

    /**
     * Reverse input string
     * @param input
     * @return
     */
    public String myReverseString(String input)
    {
        // Short-cut using StringBuilder
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();

        return sb.toString();

        // Manual approach using for loop
//        String output = "";
//
//        for (int i = input.length() - 1; i >= 0 ; i--) {
//            output = output + input.charAt(i);
//        }
//        return output;
    }


    private String[] english =
            {
                    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                    "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                    "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                    ",", ".", "?", " "
            };

    private String[] morseAlphabet =
            {
                    ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                    ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                    "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                    "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                    "-----", "--..--", ".-.-.-", "..--..", "/"
            };

    /**
     * Convert to Morse
     * @param input
     * @return
     */
    public String convertToMorse(String input)
    {
        String output = "";

        char[] chars = input.toCharArray();

        // Iterate through all characters in input
        for (char c : chars)
        {
            // Iterate through all the english characters
            for (int i = 0; i < english.length; i++)
            {
                String englishChar = english[i];
                String letterFromInput = c + ""; //adding "" to convert it to String (hacky approach)

                // Check if we have found a match
                if(letterFromInput.equalsIgnoreCase(englishChar))
                {
                    // Add the corresponding morse character to the output
                    output = output + morseAlphabet[i] + "   ";
                    break;
                }
            }
        }
        return output;
    }


    /**
     *
     * @return
     */
    public String replaceWords(String input) {

        String[] detectableWords = {"cpu", "ram", "ssd", "gpu"};
        String output = "";

        for (String word: detectableWords) {
            int indexOfWord = input.indexOf(word);

            // We have a match if indexOf returns other than -1
            if (indexOfWord != -1) {

                // Create star word with same number of characters as word
                String starWord = "";
                for (int i = 0; i < word.length() ; i++) {
                    starWord = starWord + "*";
                }

                // Overwrite original input with new modified input
                input =  input.replace(word, starWord);
            }
        }
        output = input; // Dummy transfer to output...

        return output;
    }
}
