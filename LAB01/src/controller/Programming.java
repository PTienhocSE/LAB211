package controller;

import execute.Library;
import execute.Search;
import execute.Sort;
import view.Menu;
import java.util.Scanner;
import model.Array;

public class Programming extends Menu {

    Scanner sc = new Scanner(System.in);
    private static String[] mc = {"Sort", "Search", "Exit"};
    public int[] arr;
    public int array_length;
    Library lib = new Library();
    Search search = new Search();
    Sort sort = new Sort();
    Array array = new Array();

    public Programming() {
        super("MENU", mc);
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                doSort();
                break;
            case 2:
                doSearch();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    public void doSort() {
        Programming programming = new Programming();
        String[] mcs = {"Bubble Sort", "Quick Sort", "Go Back"};
        Menu sortmenu = new Menu("Menu Sort", mcs) {
            @Override
            public void execute(int ch) {
                switch (ch) {
                    case 1:
                        int num = lib.getInt("Input size of array: ");
                        int[] arr = lib.randomArray(num);
                        System.out.println("The original Array: ");
                        lib.print(arr);
                        sort.bubbleSort(arr);
                        System.out.println("Sorted Array: ");
                        lib.print(arr);
                        break;
                    case 2:
                        int numQuick = lib.getInt("Input size of array: ");
                        int[] arrQuick = lib.randomArray(numQuick);
                        System.out.println("The original Array: ");
                        lib.print(arrQuick);
                        sort.quickSort(arrQuick, 0, arrQuick.length - 1);
                        System.out.println("Sorted Array: ");
                        lib.print(arrQuick);
                        break;
                    case 3:
                        programming.run();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        };
        sortmenu.run();
    }

    public void doSearch() {
        Programming programming = new Programming();
        String[] mcs = {"Linear Search", "Binary Search", "Go Back"};
        Menu searchmenu = new Menu("Menu Search", mcs) {
            @Override
            public void execute(int ch) {
                switch (ch) {
                    case 1:
                        int[] arr = lib.inputArray();
                        Search.linearSearch(arr);
                        break;
                    case 2:
                        int[] arr1 = lib.inputArray();
                        if (!lib.isSorted(arr1)) {
                            sort.bubbleSort(arr1);
                            System.out.println("Sorted Array: ");
                            lib.print(arr1);
                        }

                        System.out.print("Enter element: ");
                        int key = sc.nextInt();
                        int result = Search.binarySearch(arr1, key);
                        if (result == -1) {
                            System.out.println("Element not found.");
                        } else {
                            System.out.println("Element at index: " + (result + 1));
                        }
                        break;
                    case 3:
                        programming.run();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        };
        searchmenu.run();
    }

}
