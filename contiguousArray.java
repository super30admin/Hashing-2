/*
 *  * TC: O(n)
 * SC: O(n) 
 */

import java.util.HashMap;
class contiguousArray {
    public int findMaxLength(int[] nums) {

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int rSum = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); //rSum is 0 at -1, to dodge the edge case.
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0)
                rSum = rSum - 1;
            else
                rSum = rSum + 1;

            if(!map.containsKey(rSum)){
                map.put(rSum, i);
            }

            else{
                max = Math.max(max, (i - (map.get(rSum))));
            }
        }
        return max;
    }
}