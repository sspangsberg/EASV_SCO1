public class Person {
    private int id;
    private String email;
    private String name;

    /**
     *
     * @param id
     * @param email
     * @param name
     */
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String output = getId() + "\t" +
                        getName() + "\t" +
                        getEmail() + "\t";

        return output;
    }
}
