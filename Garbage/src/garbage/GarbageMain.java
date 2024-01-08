package garbage;

import garbage.Truck;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GarbageMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ban muon nhap du lieu tu ban phim hay tu tep tin? ");
        System.out.println("1. Nhap tu ban phim.");
        System.out.println("2. Nhap tu file.");

        int choice = 0;

        while (choice != 1 && choice != 2) {
            System.out.print("Nhap lua chon: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice != 1 && choice != 2) {
                System.out.println("Lua chon khong hop le. Vui long nhap lai.");
            }
        }

        if (choice == 1) {
            System.out.println("Nhap khoi luong rac tai moi tram(kg): ");
            String[] input = scanner.nextLine().split(" ");
            int[] gLoads = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                gLoads[i] = Integer.parseInt(input[i]);
            }
            new Truck(gLoads).start();
        } else if (choice == 2) {
            System.out.print("Nhap ten file chua khoi luong rac: ");
            String filePath = scanner.nextLine();
//            String filePath = "input_garbage.txt";

            try {
                File file = new File(filePath);
                try ( Scanner fileScanner = new Scanner(file)) {
                    String[] input = fileScanner.nextLine().split(" ");
                    int[] gLoads = new int[input.length];
                    for (int i = 0; i < input.length; i++) {
                        gLoads[i] = Integer.parseInt(input[i]);
                    }

                    new Truck(gLoads).start();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Khong tim thay file. Vui long kiem tra lai duong dan.");
            } catch (NumberFormatException e) {
                System.out.println("Du lieu trong file khong hop le. Vui long thu lai!!");
            }

        }
    }
}
