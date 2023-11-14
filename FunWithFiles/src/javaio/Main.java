package javaio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static java.nio.file.StandardOpenOption.*;

//@SuppressWarnings("ALL")
public class Main {

    private static final String filePathString = "data/MyFile.txt";
    private static Path filePath = Path.of(filePathString);

    private static List<Person> persons = new ArrayList<>();

    /**
     *
     * @param args
     */
    public static void main(String[] args) {



        // Object serialization stuff...
        //setupDataForObjSerialization();

        //List<Person> personsFromFile = loadPersons();
        //System.out.println(personsFromFile);
        //savePersons(persons);



        //printFileContents();
        //searchForMovie("The Hunters");
        //addTextAtLine("Fortran", 5);

        //printFileContents();
        //writeToFile("New Programming Language");
        //addTextAtLine("Inserted Line",3);
        printFileContents();
    }

    /**
     *
     */
    private static void setupDataForObjSerialization() {
        Person p1 = new Person(2, "Bill Gates");
        Person p2 = new Person(1,"Steve Jobs");
        Person p3 = new Person(3, "Larry Elison");

        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
    }


    /**
     *
     * @return
     */
    private static List<Person> loadPersons() {

        // try-with-resources to enable auto-closable
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePathString));)
        {
            return (List<Person>) ois.readObject();
        }
        // catch multiple exceptions in one catch clause (with single pipe)
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    /**
     *
     * @param persons
     */
    private static void savePersons(List<Person> persons) {

        // try-with-resources to enable auto-closable
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePathString)))
        {
            oos.writeObject(persons);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param text
     * @param lineNumber
     */
    private static void addTextAtLine(String text, int lineNumber) {

        try {
            // Read the old file first
            List<String> allLines = Files.readAllLines(filePath);
            allLines.add(lineNumber, text);

            // Create new temp file
            Path tempPathFile = Path.of(filePathString+ "_TEMP");
            Files.createFile(tempPathFile);

            // For all lines...
            for (String line: allLines)
                Files.write(tempPathFile, (line + "\r\n").getBytes(),APPEND);

            // Overwrite the old file with temp file
            Files.copy(tempPathFile, filePath, REPLACE_EXISTING);
            Files.deleteIfExists(tempPathFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    private static void printFileContents() {
        System.out.println("--------------------------------");

        // try-with-resources
        try (FileReader fr = new FileReader(filePathString);
             BufferedReader br = new BufferedReader(fr)) {

            // Standard IO Scanner
            /*
            Scanner sc = new Scanner(fr); // not thread-safe
            while(sc.hasNext()) {
                System.out.println(sc.nextLine());
            }
            */

            /*
            // Standard IO Buffered Reader
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            */

            // Java NIO lambda
            Files.lines(filePath).forEach(line -> System.out.println(line));

            // readString nio static method call
            //System.out.println(Files.readString(filePath));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param newLineContent
     */
    private static void writeToFile(String newLineContent) {
        try {
            /*
            // Standard IO
            FileWriter fileWriter = new FileWriter(filePathString, true);
            fileWriter.append(newLineContent + "\r\n");
            fileWriter.close();
            */

            // Java NIO
            Files.write(filePath, newLineContent.getBytes(), APPEND);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param wanted
     */
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