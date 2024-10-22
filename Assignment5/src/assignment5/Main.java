package assignment5;

import assignment5.be.GradeInfo;
import assignment5.be.Person;
import assignment5.be.Student;
import assignment5.be.Teacher;
import assignment5.gui.MainMenu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       //demoApp();
       runConsoleMenu();



    }


    /**
     *
     */
    private static void demoApp() {

        List<Person> persons = new ArrayList<>();

        /*
        // Create assignment5.be.Person objects (from assignment5.be.Person class blueprint)
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
        */


        // Create assignment5.be.Person objects (from assignment5.be.Person class blueprint)
        Student s1 = new Student(200,"Student #1","Computer Science");
        s1.setEmail("s1@easv.dk");
        s1.addGrade(new GradeInfo("SCO1", 10));
        s1.addGrade(new GradeInfo("SDE", 7));

        Student s2 = new Student(201,"Student #2", "Multimedia Designer");
        s2.setEmail("s2@easv.dk");
        s2.addGrade(new GradeInfo("Design and Development", 7));
        s2.addGrade(new GradeInfo("User Experiences", 4));

        Student s3 = new Student(202,"Student #3", "PBA Software Development");
        s3.setEmail("s3@easv.dk");
        s3.addGrade(new GradeInfo("Development of Large Systems", 10));
        s3.addGrade(new GradeInfo("Databases for Developers", 10));

        // Add objects to ArrayList
        persons.add(s1);
        persons.add(s2);
        persons.add(s3);




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

    /**
     *
     */
    private static void runConsoleMenu() {
        new MainMenu().run();
    }
}