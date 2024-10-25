package wow.be;

public class MagicCharacter extends Character {

    private String spell;

    /**
     *
     * @param name
     * @param race
     * @param clazz
     * @param health
     * @param weapon
     * @param spell
     */
    public MagicCharacter(String name, Race race, Clazz clazz, int health, Weapon weapon, String spell) {
        super(name, race, clazz, health, weapon);
        this.spell = spell;
    }


    public void useSpell() {
        System.out.println(getRace() + " using spell:" + spell);
    }

    @Override
    public String toString() {
        return super.toString() + ", " +
                "Spells: {" + spell + "}";
    }
}
