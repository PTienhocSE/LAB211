package excute;

import java.util.Scanner;

/**
 *
 * @author phuct
 */
public class Library {
    Scanner sc = new Scanner(System.in);

    public void display(String string) {
        System.out.println(string);
    }

    public String inputContent() {
        System.out.println("Enter your content:");
        return sc.nextLine();
    }
}

