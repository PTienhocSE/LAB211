package controller;

import model.Content;
import java.io.*;
import java.util.Scanner;

public class Programming {

    private Scanner scanner;
    private Library library;
    private ContentController contentController;

    public Programming() {
        this.scanner = new Scanner(System.in);
        this.library = new Library();
        this.contentController = new ContentController();
    }

    public void run() {
        System.out.print("Enter input file name: ");
        String inputFilename = scanner.nextLine();
        Content content = library.readFile(inputFilename);

        if (content.isEmpty()) {
            System.out.println("The input file is empty.");
        } else {

            System.out.println("Original content:");
            System.out.print(content.getText());

            contentController.formatContent(content);

            System.out.println("\nFormatted content:");
            System.out.println(content.getText());

            System.out.print("Enter output file name: ");
            String outputFilename = scanner.nextLine();
            library.writeFile(outputFilename, content.getText(), false);
            System.out.println("Formatted content has been written to " + outputFilename);
        }
    }

    public static void main(String[] args) {
        Programming program = new Programming();
        program.run();
    }
}
