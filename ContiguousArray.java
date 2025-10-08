// 525. Contiguous Array
// https://leetcode.com/problems/contiguous-array/description/

/**
 * Time Complexity: O(n) since we iterate over all numbers
 * Space Complexity: O(n) because in worst case if all numbers are either 1 or 0, we would save new rSum in map
 */


class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();

        int rSum = 0;
        int max = 0;

        map.put(0, -1); // handle edge case => if balanced subarray starts from 0th index, we need to capture that subarray too.

        for(int i = 0 ; i < nums.length ; i++){
            
            if(nums[i] == 1){
                rSum = rSum + 1;
            }else{
                rSum = rSum - 1;
            }

            if(map.containsKey(rSum)){   // if rSum is already in map that means all the elements after it are balanced i.e amount of increment == amount of decrememnt
                max = Math.max(max, i - map.get(rSum));
            }else{
                map.put(rSum, i);
            }
        }

        return max;
    }
}