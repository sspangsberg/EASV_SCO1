import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        // Create Person objects (from Person class blueprint)
        Person p1 = new Person(100,"Hans Nielsen");
        p1.setEmail("hnk@easv.dk");

        Person p2 = new Person(101,"Niels Hansen");
        p2.setEmail("nha@easv.dk");

        Person p3 = new Person(102,"Ib Boesen");
        p3.setEmail("ibo@easv.dk");

        // Add objects to ArrayList
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);


        // Teachers
        Teacher jle = new Teacher(104, "Jeppe Moritz Led", "jle");
        jle.setEmail("jle@easv.dk");
        jle.getSubjects().add("SCO1");
        jle.getSubjects().add("SCO2");
        jle.setSalary(36000);

        Teacher bhp = new Teacher(105, "Bent H. Pedersen", "bhp");
        bhp.setEmail("bhp@easv.dk");
        bhp.getSubjects().add("DBOS");
        bhp.getSubjects().add("Parallel Programming");
        bhp.setSalary(36000);

        persons.add(jle);
        persons.add(bhp);


        for (Person p: persons) {
            System.out.println(p);
        }
    }
}