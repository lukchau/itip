package lab4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;

public class CustomInputMismatchException extends InputMismatchException {
    public CustomInputMismatchException(String message) {
        super(message);
        logError(message);
    }

    public static void logError(String error) {
        try {
            File log = new File("error.txt");
            FileWriter writer = new FileWriter(log);
            writer.write(error);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
