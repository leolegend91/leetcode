package leetcode.LargestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,2,3};
        List<Integer> result = solution.largestDivisibleSubset(nums1);
        System.out.println(result);
        int[] nums2 = {1,2,4,8};
        result = solution.largestDivisibleSubset(nums2);
        System.out.println(result);
        int[] nums3 = {3,6,17,34};
        result = solution.largestDivisibleSubset(nums3);
        System.out.println(result);
    }

}

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length < 1) {
            return new LinkedList<Integer>();
        }
        Arrays.sort(nums);
        List<Integer> result = new LinkedList<Integer>(Arrays.asList(nums[0]));
        List<LinkedList<Integer>> dpList = new ArrayList<LinkedList<Integer>>();
        for (int i : nums) {
            dpList.add(new LinkedList<Integer>(Arrays.asList(i)));
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dpList.get(j).size() >= dpList.get(i).size()) {
                        dpList.set(i, new LinkedList<Integer>(dpList.get(j)));
                        dpList.get(i).add(nums[i]);
                    }
                }
            }
            LinkedList<Integer> currentList = dpList.get(i);
            if (currentList.size() > result.size()) {
                result = currentList;
            }
        }
        return result;
    }
}
