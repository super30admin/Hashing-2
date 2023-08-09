//TC : O(n)
//SC : O(n)

import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> hmap = new HashMap<>();
        int sum = 0;
        int count = 0;
        hmap.put(0, -1); // put -1 as dummy entry
        for(int i=0; i< nums.length; i++){
            if(nums[i]==0){
                sum = sum-1;
            }
            else {
                sum= sum+1;
            }
            if(hmap.containsKey(sum)){
                count = Math.max(count, i - hmap.get(sum));
            }
            else {
                hmap.put(sum, i); }
        }
        return count;
    }
}

