package execute;

public class Search {
    public static int findLinearSearch(int arr[], int N, int x) {
        for (int i = 0; i < N; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    public static void linearSearch(int[] arr) {
        System.out.print("Enter element: ");
        int x = new java.util.Scanner(System.in).nextInt();
        int result = findLinearSearch(arr, arr.length, x);
        if (result == -1)
            System.out.println("Element is not in array");
        else
            System.out.println("Element at index: " + (result+1));
    }

    public static int binarySearch(int arr[], int key) {
        int first = 0;
        int last = arr.length - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] == key) {
                return mid;
            } else {
                last = mid - 1;
            }
        }
        return -1; // Element not found
    }
}
