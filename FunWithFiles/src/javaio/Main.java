package javaio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static java.nio.file.StandardOpenOption.*;

//@SuppressWarnings("ALL")
public class Main {

    private static final String filePathString = "data/MyFile.ser";
    private static Path filePath = Path.of(filePathString);

    public static void main(String[] args) {

        /*
        Person p1 = new Person(2, "Bill Gates");
        Person p2 = new Person(1,"Steve Jobs");
        Person p3 = new Person(3, "Larry Elison");

        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
*/

        List<Person> personsFromFile = loadPersons();
        System.out.println(personsFromFile);

        //savePersons(persons);


        //printFileContents();

        //searchForMovie("The Hunters");

        //addTextAtLine("Fortran", 5);

        //printFileContents();
    }

    private static List<Person> loadPersons() {

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePathString));
            return (List<Person>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }

        return null;
    }

    private static void savePersons(List<Person> persons) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filePathString));
            oos.writeObject(persons);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void addTextAtLine(String text, int lineNumber) {

        try {
            // Read the old file first
            List<String> allLines = Files.readAllLines(filePath);
            allLines.add(lineNumber, text);

            // Create new temp file
            Path tempPathFile = Path.of(filePathString+ "_TEMP");
            Files.createFile(tempPathFile);

            // Add all the lines
            for (String line: allLines)
                Files.write(tempPathFile, (line + "\r\n").getBytes(),APPEND);

            // Overwrite the old file with temp file
            Files.copy(tempPathFile, filePath, REPLACE_EXISTING);
            Files.deleteIfExists(tempPathFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static void printFileContents() {
        System.out.println("--------------------------------");

        try {
            // Lambda expression
            //Files.lines(Path.of(filePath)).forEach(line -> System.out.println(line));

            // readString nio static method call
            System.out.println(Files.readString(filePath));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void searchForMovie(String wanted) {
        System.out.println("--------------------------------");

        try {
            List<String> allLines = Files.readAllLines(filePath);

            for (int i = 0; i < allLines.size(); i++) {
                if (allLines.get(i).trim().contains(wanted)) {
                    System.out.println("Found " + wanted + " at line " + i);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}