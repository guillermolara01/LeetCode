import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> permutations = new ArrayList<>();
        int[] swapCounts = new int[n];  // Track swap counts per index

        // Add the initial array, since it's a permutation itself.
        permutations.add(toList(nums));

        int index = 0;
        while (index < n) {
            if (swapCounts[index] < index) {
                // Decide which index to swap with
                if (index % 2 == 0) {
                    swap(nums, 0, index); // Swap first and current (even index)
                } else {
                    swap(nums, swapCounts[index], index); // Swap with tracked index (odd index)
                }

                permutations.add(toList(nums)); // Add new permutation

                swapCounts[index] += 1;
                index = 0;
            } else {
                // when the ocount is greater than the index, then we have all the permutations we can form with the 
                // current index, so we reset the count and advance and index
                swapCounts[index] = 0;
                index += 1;
            }
        }

        return permutations;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        System.out.println(permute(nums1));

        int[] nums2 = {0, 1};
        System.out.println(permute(nums2));

        int[] nums3 = {1};
        System.out.println(permute(nums3));
    }
}
