package handlers;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Menu {

    public void menuShow() throws ParseException, IOException {
        CreateCatalogStructure.createHomeFile();
        CreateCatalogStructure.createDevFile();
        CreateCatalogStructure.createTestFile();
        CreateCatalogStructure.newCountFile();
        System.out.println("Welcome to file segregation. Let's get started.");
        System.out.println("You have multiple choice:");

        Scanner scan = new Scanner(System.in);
        String request = "0";

        while (!request.equals("4")) {
            CountFileNumber.countFileNumber();
            System.out.println("1 New file");
            System.out.println("2 Segregate all files from HOME catalog");
            System.out.println("3 Number of files in specific directory");
            System.out.println("4 End my work");
            System.out.println("Choose a number:");
            request = scan.nextLine();

            switch (request) {
                case "1":
                    NewFile.newFile();
                    break;
                case "2":
                    SegregateFilesFromHome.segregateFilesFromHomeDir();
                    break;
                case "3":
                    CountFileNumber.readFileNumber();
                    break;
                case "4":
                    System.out.println("See You next time!");
                    break;
                default:
                    System.out.println("!!! There was no reasonable choice !!!");
                    break;
            }
        }
    }
}
