package lab4;

import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        try {
            File currentFile = new File("file1.txt");
            File file = new File("newFile.txt");
            Scanner scanner = new Scanner(currentFile);
//            scanner.close();
            try {
                FileWriter writer = new FileWriter(file);
                //writer.close();
                while (scanner.hasNextLine()) {
                    writer.write(scanner.nextLine());
                    writer.write("\n");
                }
                writer.close();
                scanner.close();
            } catch (IOException e) {
                System.err.println("Error while writing file");
            }

        } catch (FileNotFoundException e) {
            System.err.println("File was not found");
        } catch (IllegalStateException e) {
            System.err.println("Поток закрыт");
        }


    }
}

