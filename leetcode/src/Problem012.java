import java.util.Arrays;
import java.util.Scanner;

public class Problem012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements you wish to sort: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int random = (int) (1 + Math.random() * 100);
            arr[i] = random;
        }
        System.out.println(Arrays.toString(arr));

        System.out.println("Which sorting method do you wish to use to sort the elements of the above array? ");
        System.out.println("1. MERGE SORT\n2. QUICK SORT");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                int[] ans = mergeSortAlgo(arr);
                printArray(ans);
                break;
            case 2:
                quickSortAlgo(arr);
                printArray(arr);
                break;
            default:
                break;
        }
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSortAlgo(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = arr[(low + high) / 2];
        int index = partition(arr, pivot, low, high);
        System.out.println(index);
        quickSort(arr, low, index - 1);
        quickSort(arr, index, high);
    }

    private static int partition(int[] arr, int pivot, int low, int high) {
        while (low <= high) {
            while (arr[low] < pivot) {
                low++;
            }

            while (arr[high] > pivot) {
                high--;
            }

            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int[] mergeSortAlgo(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        return mergeSort(arr, low, high);
    }

    private static int[] mergeSort(int[] arr, int low, int high) {
        if (low == high) {
            return new int[]{arr[low]};
        }

        int mid = low + (high - low)/2;
        int[] left = mergeSort(arr, low, mid);
        int[] right = mergeSort(arr, mid + 1, high);
        return merge(left, right);
    }

    private static int[] merge(int[] a, int[] b) {
        int len1 = a.length;
        int len2 = b.length;
        int[] res = new int[len1 + len2];

        int i = 0, j = 0, k = 0;
        while (i < len1 && j < len2) {
            if (a[i] < b[j]) {
                res[k] = a[i];
                i++;
                k++;
            } else {
                res[k] = b[j];
                j++;
                k++;
            }
        }

        while (i < len1) {
            res[k] = a[i];
            i++;
            k++;
        }

        while (j < len2) {
            res[k] = b[j];
            j++;
            k++;
        }

        return res;
    }
}
