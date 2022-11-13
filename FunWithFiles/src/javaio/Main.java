package javaio;

import java.io.*;
import java.util.Scanner;

//@SuppressWarnings("ALL")
public class Main {

    private static final String filePath = "data/MyFile.txt";

    public static void main(String[] args) {

        printFileContents();

        searchForMovie("Java");

        addTextAtLine("Cobol", 3);

        //printFileContents();
    }

    private static void addTextAtLine(String text, int lineNumber) {
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr))
        {
            String fileInput = "";
            int counter = 1;

            String line;
            while ((line = br.readLine()) != null) {
                if (counter == lineNumber)
                    fileInput += text + "\r\n";

                fileInput += line + "\r\n";
                counter++;

                System.out.println(line);
            }

            try (FileWriter fw = new FileWriter(filePath);
                 BufferedWriter bw = new BufferedWriter(fw)) {

                fw.append(fileInput);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static void printFileContents() {
        System.out.println("--------------------------------");

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr))
        {
            /*

            Scanner scanner = new Scanner(fr);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
            */

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void searchForMovie(String wanted) {
        System.out.println("--------------------------------");

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr))
        {
            int counter = 0;

            String line;
            while ((line = br.readLine()) != null) {

                if (line.trim().contains(wanted)) {
                    System.out.println("Found " + line + " at line " + counter);
                    break;
                }
                counter++;
            }

        }
        catch (Exception e) {
            System.out.println("The file was not found");
        }
    }
}