import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

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
}