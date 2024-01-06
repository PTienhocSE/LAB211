
package execute;

public class Sort {
    public void bubbleSort(int[] arr) {
        if (arr == null) {
            System.out.println("Array is null.");
            return;
        }

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean haveSwap = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    haveSwap = true;
                }
            }

            if (!haveSwap) {
                break;
            }
        }
    }
    
    public int partition(int[] array, int low, int high) {
        int l = low, h = high;
        int pivot = array[(low + high) / 2];
        int temp;
        while (l <= h) {
            while (array[l] < pivot) {
                l++;
            }
            while (array[h] > pivot) {
                h--;
            }
            if (l <= h) {
                temp = array[l];
                array[l] = array[h];
                array[h] = temp;
                l++;
                h--;
            }
        }
        return l;
    }

    public void quickSort(int[] arr, int low, int high) {
        int index = partition(arr, low, high);
        if (low < index - 1) {
            quickSort(arr, low, index - 1);
        }
        if (index < high) {
            quickSort(arr, index, high);
        }
    }
}
