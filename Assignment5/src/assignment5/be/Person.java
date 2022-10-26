package assignment5.be;

public abstract class Person {
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
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Person person = (Person) other;

        return id == person.id;
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
