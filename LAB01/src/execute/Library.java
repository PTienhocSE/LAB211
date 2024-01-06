package execute;

import java.util.Random;
import java.util.Scanner;

public class Library {

    private Scanner sc = new Scanner(System.in);

    public int[] inputArray() {
        System.out.print("Enter size of Array: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.nextLine();
        return arr;
    }

    public void print(int arr[]) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (i < arr.length - 1) {
                    System.out.print(arr[i] + ", ");
                } else {
                    System.out.print(arr[i]);
                }
            }
            System.out.println("");
        } else {
            System.out.println("Array is null.");
        }
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public int[] randomArray(int size) {
        int[] arr = new int[size];
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rd.nextInt(100);
        }
        return arr;
    }

    public int getInt(String message) {
        int value;
        do {
            System.out.print(message);
            value = sc.nextInt();
        } while (value < 0);
        return value;
    }

}
