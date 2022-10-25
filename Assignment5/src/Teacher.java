import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    private List<String> subjects = new ArrayList<>();
    private String initials;
    private double salary;


    /**
     *
     * @param id
     * @param name
     * @param initials
     */
    public Teacher(int id, String name, String initials) {
        super(id, name);

        this.initials = initials;
    }

    /**
     *
     * @return
     */
    public List<String> getSubjects() {
        return subjects;
    }

    /**
     *
     * @param subjects
     */
    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    /**
     *
     * @return
     */
    public String getInitials() {
        return initials;
    }

    /**
     *
     * @param initials
     */
    public void setInitials(String initials) {
        this.initials = initials;
    }

    /**
     *
     * @return
     */
    public double getSalary() {
        return salary;
    }

    /**
     *
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     *
     * @return
     */
   /*
    @Override
    public String toString() {
        String output = super.getId() + "\t" +
                        super.getName() + "\t" +
                        super.getEmail() + "\t" +
                        getInitials() + "\t" +
                        getSubjects().get(0);

        return output;
    }
    */
}
