public class Movie {

    private String title;
    private int length;
    private float rating;

    /**
     *
     * @param title
     * @param length
     */
    public Movie(String title, int length, float rating) {
        this.title = title;
        this.length = length;
        this.rating = rating;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return
     */
    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", length=" + length +
                '}';
    }
}
