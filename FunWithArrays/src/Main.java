import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        // integerDataTypes();
        // strings(); // also includes ArrayList examples
        // customClass();
        // multiDimensionalArray();
    }


    /**
     *
     */
    private static void integerDataTypes() {
        // declaration and instantiation
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("Value at index 0:" + numbers[0]);
        System.out.println("Value at last index (9):" + numbers[9]);

        numbers[7] = 50; // set array value

        // Iterating over int array using enhanced for
        for (int number : numbers) {
            System.out.println(number);
        }

        // Iterating over int array using normal for loop
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }


    /**
     *
     */
    private static void customClass() {

        // Create some movie objects
        Movie m1 = new Movie("Terminator 2", 245, 8.5F);
        Movie m2 = new Movie("Inception", 143, 8.3F);
        Movie m3 = new Movie("Godfather I", 256, 8.8F);

        // Normal array of Movie objects
        Movie[] movies = new Movie[5];
        movies[0] = m1;
        movies[1] = m2;
        movies[2] = m3;

        // Iterating over normal array using enhanced for loop
        for (Movie thisMovie: movies) {
            System.out.println(thisMovie);
        }
    }


    /**
     *
     */
    private static void strings() {
        //Single variable
        String name = "Barney";

        String[] names = new String[3];
        names[0] = "Homer";
        names[1] = "Bart";
        names[2] = "Sideshow Bob";

        // Escape characters (newline)
        System.out.println("Forward \n twice:");
        System.out.print("Forward:");

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        names[1] = null;

        System.out.println("Backwards:");
        for (int i = names.length - 1; i >= 0; i--) {
            System.out.println(names[i]);
        }


        //System.out.println("First variable: " + names[2]);

        System.out.println("Games.....:");

        ArrayList<String> games = new ArrayList<>();
        games.add("Doom");
        games.add("WoW");
        games.add("Dota");
        games.add("WarCraft");

        games.set(0,"Commander Keen");

        System.out.println("For:");

        for (int i = 0; i < games.size(); i++) {
            System.out.println(games.get(i));
        }

        games.remove("Dota");

        //games.clear();

        System.out.println("For-each loop");

        for (String s: games) {
            System.out.println(s);
        }
    }

    /**
     *
     */
    private static void multiDimensionalArray() {

        int COLUMNS = 3;
        int ROWS = 3;

        int[][] _2dArr =
                {
                        {1,2,3}, // row1
                        {4,5,6}, // row2
                        {7,8,9}  // row3
                };

        //int[][] _2dArr = new int[COLUMNS][ROWS];


        /*
        // Row
        _2dArr[0][0] = 1;
        _2dArr[1][1] = 2;
        _2dArr[2][2] = 3;


        /*
        // Diagonal
        _2dArr[0][0] = 1;
        _2dArr[1][1] = 2;
        _2dArr[2][2] = 3;
        */


        System.out.println(_2dArr[1][1]);


        // foreach row in the array
        for (int row = 0; row < _2dArr.length ; row++) {

            // foreach column in the current row
            for (int column = 0; column < _2dArr[0].length; column++) {
                System.out.print(_2dArr[row][column] + ", ");
            }
            System.out.println();
        }

        // resetting multi-dimensional array
        for (int i = 0; i < _2dArr.length ; i++) {
            for (int j = 0; j < _2dArr[0].length; j++) {
                _2dArr[i][j] = -1; // -1 or the value you choose to indicate "not-set"
            }
        }
    }
}