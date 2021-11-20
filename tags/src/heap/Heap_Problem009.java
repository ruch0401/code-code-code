package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Given an array of integers and two numbers k1 and k2.
 * Find the sum of all elements between given two k1’th and k2’th smallest elements of the array.
 * It may  be assumed that all elements of array are distinct.
 *
 * Example :
 * Input : arr[] = {20, 8, 22, 4, 12, 10, 14},  k1 = 3,  k2 = 6
 * Output : 26
 *          3rd smallest element is 10. 6th smallest element
 *          is 20. Sum of all element between k1 & k2 is
 *          12 + 14 = 26
 */
public class Heap_Problem009 {
    public static void main(String[] args) {
        int[][] a = {{20, 8, 22, 4, 12, 10, 14}};
        int[] k1s = {3};
        int[] k2s = {6};
        for (int i = 0; i < a.length; i++) {
            int[] arr = a[i];
            int k1 = k1s[i];
            int k2 = k2s[i];
            System.out.println(sumOfElementsBetweenk1smallestAndk2smallest(arr, k1, k2));
        }
    }

    private static int sumOfElementsBetweenk1smallestAndk2smallest(int[] arr, int k1, int k2) {
        int small1 = kthsmallest(arr, k1);
        int small2 = kthsmallest(arr, k2);
        int sum = 0;
        for (int elem: arr) {
            if (elem > small1 && elem < small2) {
                sum += elem;
            }
        }
        return sum;
    }

    private static int kthsmallest(int[] arr, int k1) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int elem : arr) {
            pq.add(elem);
            if (pq.size() > k1) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
