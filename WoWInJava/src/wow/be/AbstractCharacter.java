package wow.be;

public abstract class AbstractCharacter {

    private Race race;
    private Clazz clazz;
    private int health;
    private String name;


    public AbstractCharacter(String name, Race race, Clazz clazz, int health) {
        setName(name);
        setRace(race);
        setHealth(health);
        setClazz(clazz);
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return  getName() + ", " +
                getRace() + " " + getClazz() + ", " +
                "Health: " + getHealth();
    }
}
