import java.util.Scanner;

public class ConsoleStart {

    /**
     * Main Method of the application
     * @param args
     */
    public static void main(String[] args) {

        //exercise1();
        //exercise2();
        //exercise3();
        //exercise4();
        //exercise5();
        exercise6();
    }

    /**
     * 1. From any user input, surround the input with tags like: "input" -> "<input>".
     * Print the result to the screen
     *
     */
    private static void exercise1() {
        // create scanner object
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Exercise 1:");
        System.out.print("Write something: ");
        String input = keyboard.nextLine();

        System.out.println("You wrote this: <" + input + ">");
    }


    /**
     * 2. From any user input, count the amount of characters in the input
     * and write the number of characters to the screen
     */
    private static void exercise2() {
        // create scanner object
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Exercise 2:");
        System.out.print("Write something: ");
        String input = keyboard.nextLine();

        System.out.println("Length: " + input.length());
    }


    /**
     * 3. From any user input, separate each character in the string with a "@"
     */
    private static void exercise3() {
        // create scanner object
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Exercise 3:");
        System.out.print("Write something: ");
        String input = keyboard.nextLine();


        String output = "";
        for (int i = 0; i < input.length(); i++) // iterate through all characters in the string
        {
            if (i < input.length() - 1) // if we are NOT at the end of the string
            {
                output = output + input.charAt(i) + "@";
            }
            else
            {
                output = output + input.charAt(i);
            }
        }

        System.out.println("Output:" + output);
    }



    /**
     * 4. From any user input, write the input characters backwards
     */
    private static void exercise4() {
        // create scanner object
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Exercise 4:");
        System.out.print("Write something: ");
        String input = keyboard.nextLine();

        /*
        // Short-cut using StringBuilder
        StringBuilder sb = new StringBuilder(input);
        System.out.println("Reverse: " + sb.reverse());

        */

        // Manual approach using normal for loop
        String output = "";

        for (int i = input.length() - 1; i >= 0 ; i--) {
            output = output + input.charAt(i);
        }
        System.out.println("Reverse:" + output);
    }




    /**
     * 5. From any user input, convert the input to morse code in the form "This is cool" ->
     * "- .... .. ... / .. ... / -.-. --- --- .-..", where letter space is "space" and word is "/"
     */
    private static void exercise5() {

        String[] english =
                {
                        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                        "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                        "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                        ",", ".", "?", " "
                };

        String[] morseAlphabet =
                {
                        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                        ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                        "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                        "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                        "-----", "--..--", ".-.-.-", "..--..", "/"
                };


        // create scanner object
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Exercise 5:");
        System.out.print("Write something: ");
        String input = keyboard.nextLine();
        String output = "";

        char[] chars = input.toCharArray(); // split string into chars (in array)

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

        System.out.println("Morse result: " + output);

    }




    /**
     * 6. From any user input, check if the string contains the words
     * "horse", "saddle" or "spores" and if present, substitute them with an
     * equal amount of "*". e.g. "i am riding a blue horse" -> "i am riding a blue *****"
     */
    private static void exercise6() {

        // create scanner object
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Exercise 6:");
        System.out.print("Write something: ");
        String input = keyboard.nextLine();

        String[] detectableWords = {"horse", "saddle", "spore"};
        String output = "";

        for (String word: detectableWords) // enhanced for loop
        {
            int indexOfWord = input.indexOf(word); // get the index of the detectable word (if it matches)

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

        System.out.println("Star words: " + output);
    }
}

