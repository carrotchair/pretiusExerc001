package handlers;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class NewFile {

    private static final String pathHome = ".idea/HOME/";

    public static void newFile() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write file name with .jar or .txt:");
        String read = scan.next();
        String finalPath = pathHome + read;
        Path path = Paths.get(finalPath);

        Files.createDirectories(path.getParent());

        try {
            Files.createFile(path);
        } catch (FileAlreadyExistsException e) {
            System.err.println("File already exists: " + e.getMessage());
        }
    }
}
