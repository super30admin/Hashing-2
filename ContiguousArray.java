// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :

import java.util.HashMap;

class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int rSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i=0; i< nums.length; i++){

            if(nums[i] == 0){
                rSum = rSum -1;
            }else{
                rSum = rSum +1;
            }

            if(!map.containsKey(rSum)){
                map.put(rSum, i);
            }else{
                int firstOccurance = map.get(rSum);

                if(max < i - firstOccurance){
                    max = i - firstOccurance;
                }
            }
        }
        return max;
    }
}
