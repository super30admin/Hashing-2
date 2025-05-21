//equal no of 0s and 1s, add 1 for 1s and subtract 1 for 0s from sum (prefix sum)
//Time complexity: O(n)
//Space complexity: O(n)

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum =0, max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum-=1;
            }
            else{
                sum+=1;
            }
            if(sum==0){
                max = i+1;
            }
            else if(map.containsKey(sum)){
                max = Math.max(max, i-map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }
        return max;
    }
}