package javaio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class Main {

    private static final String filePath = "/Users/user/Work/Development/EASV_SCO1/FunWithFiles/Resources/MyFile.txt";

    public static void main(String[] args) {

        printFileContents();

        addTextAtLine("JavaScript", 3);

        printFileContents();
    }

    private static void addTextAtLine(String text, int lineNumber) {
        FileReader fr = null;

        try {
            String fileInput = "";
            fr = new FileReader(filePath);
            Scanner scanner = new Scanner(fr);
            int counter = 1;
            while (scanner.hasNext()) {
                fileInput += scanner.nextLine() + "\r\n";
                if (counter == lineNumber)
                    fileInput += text + "\r\n";

                counter++;
            }

            fr.close();
            FileWriter fw = new FileWriter(filePath);
            fw.append(fileInput);
            fw.close();


        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static void printFileContents() {
        System.out.println("--------------------------------");

        try {
            FileReader fr = new FileReader(filePath);
            Scanner scanner = new Scanner(fr);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
            fr.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}