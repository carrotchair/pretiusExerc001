package handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CountFileNumber {


    public static void countFileNumber() throws IOException {

        File folderHome = new File(".idea/HOME/");
        File folderDev = new File(".idea/DEV/");
        File folderTest = new File(".idea/TEST/");
        long numberOfFilesInHome = Arrays.stream(folderHome.listFiles()).count();
        long numberOfFilesInDev = Arrays.stream(folderDev.listFiles()).count();
        long numberOfFilesInTest = Arrays.stream(folderTest.listFiles()).count();

        try {
            FileWriter myWriter = new FileWriter(".idea/HOME/count.txt");
            myWriter.write("Number of files in Home directory: " + numberOfFilesInHome + '\n');
            myWriter.write("Number of files in Dev directory: " + numberOfFilesInDev + '\n');
            myWriter.write("Number of files in Test directory: " + numberOfFilesInTest);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileNumber() {
        try {
            File myObj = new File(".idea/HOME/count.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
