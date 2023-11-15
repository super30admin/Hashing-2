//Time Complexity : O(n)
//Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

import java.util.HashMap;
/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
Brute force method takes O(npow3) Time Complexity.
To optimize, use Running Sum method. Can implement setting -1 to 0 and +1 to 1
 */
public class ContiguousArray {

    public int contiguousArray(int[] in) {
        int max = 0; //Max of length of contiguous sub arrays
        int rSum = 0; //Running sum variable
        HashMap<Integer,Integer> map = new HashMap<>(); //Map containing running sum key, index value
        map.put(0, -1); //start with -1 index to handle edge condition of not missing first element

        for(int i=0; i<in.length; i++) {
            //Decrease rSum by -1 for 0 and increase by 1 for 1
            if(in[i] == 0) rSum--;
            else rSum++;

            if(map.containsKey(rSum))
                max = Math.max(max, i - map.get(rSum)); //length of sub array will be current index - last occurrence index of rSum
            else
                map.put(rSum, i);

        }

        return max;
    }

    public static void main(String args[]) {
        int[] ip = new int[]{0, 0, 1, 1};
        System.out.println("Max length of subarray with equal 0 and 1:" + new ContiguousArray().contiguousArray(ip));

        ip = new int[]{0, 1};
        System.out.println("Max length of subarray with equal 0 and 1:" + new ContiguousArray().contiguousArray(ip));
    }
}
