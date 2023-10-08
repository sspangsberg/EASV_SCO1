import java.util.Objects;

public class Game implements IGame {
    private String title;
    private String type;

    public Game() {

    }

    public Game(String title, String type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Game game = (Game) other;

        if (!Objects.equals(title, game.title)) return false;
        return Objects.equals(type, game.type);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }


    // object class .toString()
    // gør det pænere
    @Override
    public String toString() {

        return "Game{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public void start() {

    }

    @Override
    public int getScore() {
        return 0;
    }
}
