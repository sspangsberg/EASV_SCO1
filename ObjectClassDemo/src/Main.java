import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    // multi-dimensional array
    final static int ROWS = 3, COLUMNS = 3;
    private static int[][] board = new int[ROWS][COLUMNS];

    /**      COLUMNS
     *         012
     *       0 ---
     *  ROWS 1 ---
     *       2 ---
     *
     */

    public static void main(String[] args) {


        // iterating over a multi-dimensional array
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = row * column;

                System.out.print(board[row][column] + "\t");
            }
            System.out.println();
        }

        // extends Object
        Integer[] numberInteger = new Integer[5];
        int[] numbers = new int[5];
        numbers[0] = 2;
        numbers[1] = 20;
        numbers[2] = 200;
        numbers[3] = 2000;
        numbers[4] = 20000;

        for (int n: numbers) {
            System.out.println(n);
        }

        // ArrayIndexOutOfBoundsException...
        //numbers[5] = 20000;

    //    System.out.println(n + "");

        // objects !primitive
        // generics
        ArrayList<Integer> numbersList = new ArrayList<>();
        numbersList.add(13);
        numbersList.add(24);

       // numbersList = new LinkedList<>();

        int result = numbersList.get(0) + numbersList.get(1);


        ArrayList items = new ArrayList(); // object

        Game game1 = new Game("Wolfenstein","3D Shooter");
        Game game2 = new Game("WarCraft 1", "Strategy");
        Game game3 = new Game("WarCraft 1", "Strategy");

        ArrayList<Game> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);
        games.add(game3);

        for (Game g: games) {
            System.out.println(g);
        }

        for (int i = 0; i < games.size(); i++) {
            System.out.println(games.get(i));
        }

        Game newGame = new Game();
        //newGame = new Game("");

        newGame.setTitle("LoL");
        newGame.setType("MOBA");

        System.out.println("Are equal:" + game2.equals(game3));
    }
}