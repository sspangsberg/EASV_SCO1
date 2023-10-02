import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

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