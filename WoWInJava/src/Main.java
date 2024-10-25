import wow.be.*;
import wow.be.Character;

public class Main {

    public static void main(String[] args)
    {
        Character warrior = new Character(
                "Varian Wrynn",
                Race.Human,
                Clazz.Warrior,
                400,
                new Weapon("Shalamayne Sword", 80)
        );

        MagicCharacter paladin = new MagicCharacter(
                "Uther Lightbringer",
                Race.Human,
                Clazz.Paladin,
                350,
                new Weapon("The Hammer of the Lightbringer", 67),
                "Healing"
        );

        MagicCharacter warlock = new MagicCharacter(
                "Gul'dan",
                Race.Orc,
                Clazz.Warlock,
                320,
                new Weapon("Staff of Gul'dan", 98),
                "Curse");

        System.out.println("Current characters in the game:");
        System.out.println(warrior);
        System.out.println(paladin);
        System.out.println(warlock);

        warlock.attack(paladin);
        paladin.useSpell();

        System.out.println("Paladin health:" + paladin.getHealth());
        System.out.println("Warlock health:" + warlock.getHealth());
    }
}