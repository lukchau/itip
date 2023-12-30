package lab4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TypeChecker typeChecker = new TypeChecker();

        try {
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();
            System.out.println("You entered: " + number);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input");
            logError("Mismatch exception: Invalid type");
        }
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

