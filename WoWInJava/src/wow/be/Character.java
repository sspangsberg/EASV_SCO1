package wow.be;

public class Character extends AbstractCharacter {

    private Weapon weapon;

    /**
     *
     * @param name
     * @param race
     * @param health
     * @param clazz
     * @param weapon
     */
    public Character(String name, Race race, Clazz clazz, int health, Weapon weapon) {
        super(name, race, clazz, health);
        setWeapon(weapon);
    }


    public void attack(Character enemy) {
        // calc based on weapon how much damage
        setHealth(getHealth() - enemy.getWeapon().getDamage());
        enemy.setHealth(enemy.getHealth() - getWeapon().getDamage());
    }


    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return super.toString() + ", " +
                weapon.toString();
    }
}
