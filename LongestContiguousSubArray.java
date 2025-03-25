package week2;

import java.util.HashMap;

public class LongestContiguousSubArray {

    //Running sum
    // 2 pointers
    //brute force
    static int start, end;
    public void findLongestBruteForce(int[] arr) {

        for(int j = 0 ; j < arr.length ; j++) {
            for (int i = j; i < arr.length; i++) {

            }
        }
    }

    public int findLongestOptimal(int[] nums) {

        int rSum = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0 ; i < nums.length ; i++) {

            int num = nums[i];
            if(num == 0) rSum--;
            else rSum++;

            if(map.containsKey(rSum)) {
                max = Math.max(max, i - map.get(rSum));
            } else {
                map.put(rSum, i);
            }
        }
        return max;
    }

    public static int findSubArray(int[] nums) {
        int prefixSum = 0;
        int max = 0;
        int prefixArr[] = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] == 0) {
                prefixSum--;
            } else {
                prefixSum++;
            }
            prefixArr[i] = prefixSum;
            if(map.containsKey(prefixSum)) {

                if(max < i - map.get(prefixSum)) {
                    start = map.get(prefixSum)+1;
                    end = i;
                }
                max = Math.max(max, i - map.get(prefixSum));
            } else {
                //first time entry
                map.put(prefixSum, i);
            }
        }
        for(int num : prefixArr) {
            System.out.print(" " + num);
        }
        return max;
    }

    public static int findSubArrayUpdatedCondition(int[] nums) {

        int prefixSum = 0;
        int max = 0;
        int prefixArr[] = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] == 0) {
                prefixSum--;
            } else {
                prefixSum++;
            }
            prefixArr[i] = prefixSum;

            if(prefixSum == 0) {
                max = Math.max(max, i+1);
                //i+1 as we want the length. i starts from 0th index a
            }
            else if(map.containsKey(prefixSum)) {
                if(max < i - map.get(prefixSum)) {
                    start = map.get(prefixSum)+1;
                    end = i;
                }
                max = Math.max(max, i - map.get(prefixSum));
            } else {
                //first time entry
                map.put(prefixSum, i);
            }
        }
        for(int num : prefixArr) {
            System.out.print(" " + num);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {0,1,0,1,1,0,1,0,0,0,1,1,0};
        int maxLength = findSubArray(nums);
        System.out.println("\nstart: " + start + " end: " + end);
        System.out.println("\nMax Length:: " + maxLength);
    }

}
