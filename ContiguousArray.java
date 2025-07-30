import java.util.HashMap;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//figuring out the running some logic was a thing, but after figuring it out based on th nested arrays logic felt little easy to follow
public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //putting 0 and -1th index will resolve the edge case issue which is skipping the first index
        map.put(0, -1);
        int max = 0;
        int rSum = 0;
        for (int i = 0; i < nums.length; i++) {
            //having running sum logic where decrement the sum by 1 if the array element is 0
            if (nums[i] == 0) {
                rSum--;
            }
            //having running sum logic where increment the sum by 1 if the array element is 1
            else {
                rSum++;
            }
            //if hashmap already contains the running sum that means we have a subarray between the current index and the hashmap value
            if (map.containsKey(rSum)) {
                max = Math.max(max, i - map.get(rSum)); // so we make difference of the current index and value of running sum
            } else {
                //if running sum value is not present in the map then we add that running sum and its index into the map
                map.put(rSum, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 1, 1, 0, 0, 0};
        System.out.println(findMaxLength(nums)); //Expected 6
    }
}
