package handlers;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateCatalogStructure {

    private static final String path = ".idea/";
    private static final String homeDirectory = "HOME";
    private static final String devDirectory = "DEV";
    private static final String testDirectory = "TEST";

    public static void createHomeFile() {
        String finalPath = path + homeDirectory;
        File f1 = new File(finalPath);
        boolean bool = f1.mkdir();
        if (bool) {
        } else {
        }
    }

    public static void createDevFile() {
        String finalPath = path + devDirectory;
        File f1 = new File(finalPath);
        boolean bool = f1.mkdir();
        if (bool) {
        } else {
        }
    }

    public static void createTestFile() {
        String finalPath = path + testDirectory;
        File f1 = new File(finalPath);
        boolean bool = f1.mkdir();
        if (bool) {
        } else {
        }
    }

    public static void newCountFile() throws IOException {
        String pathHome = ".idea/HOME/";
        String countFile = "count.txt";
        String finalPath = pathHome + countFile;
        Path path = Paths.get(finalPath);

        Files.createDirectories(path.getParent());

        try {
            Files.createFile(path);
        } catch (FileAlreadyExistsException e) {
        }
    }

}
