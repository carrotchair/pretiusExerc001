package handlers;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.TimeUnit;

public class SegregateFilesFromHome {

    public static void segregateFilesFromHomeDir() throws IOException {

        File folder = new File(".idea/HOME/");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().endsWith(".jar")) {
                String fileName = listOfFiles[i].getName();
                System.out.println(fileName);
                Path source = Paths.get(".idea/HOME/" + fileName);
                BasicFileAttributes fatr = Files.readAttributes(source,
                        BasicFileAttributes.class);

                long fileCreationTime = fatr.creationTime().to(TimeUnit.HOURS);

                if(fileCreationTime%2 == 0) {
                    String fileName1 = listOfFiles[i].getName();
                    Path source1 = Paths.get(".idea/HOME/" + fileName1);
                    Path newdir1 = Paths.get(".idea/DEV/");
                    Files.move(source, newdir1.resolve(source1.getFileName()),
                            StandardCopyOption.REPLACE_EXISTING);
                } else {
                    String fileName2 = listOfFiles[i].getName();
                    Path source2 = Paths.get(".idea/HOME/" + fileName2);
                    Path newdir2 = Paths.get(".idea/TEST/");
                    Files.move(source, newdir2.resolve(source2.getFileName()),
                            StandardCopyOption.REPLACE_EXISTING);
                }

            } else if (listOfFiles[i].getName().endsWith(".xml")) {
                String fileName = listOfFiles[i].getName();
                Path source = Paths.get(".idea/HOME/" + fileName);
                Path newdir = Paths.get(".idea/DEV/");
                Files.move(source, newdir.resolve(source.getFileName()),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}
