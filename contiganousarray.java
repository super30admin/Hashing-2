// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
//Approach:We will use new datastr rSum to find the max length,convert 0s to -1s and 1 to adding 1 and compute a running sum (rSum). We use a hash map to store the first index at which each running sum appears. If the same rSum appears again, it means the subarray between those indices has equal 0s and 1s, and we update the max length accordingly.
import java.util.HashMap;
class Solution {
    public int findMaxLength(int[] nums) {
        if(nums==null || nums.length==0 || nums.length==1){
            return 0;
        }
        HashMap<Integer,Integer> map= new HashMap<>();

        int rSum=0,max=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                rSum= rSum-1;
            } else{
                rSum=rSum+1;
            }
            if(map.containsKey(rSum)){
                max=Math.max(max, i- map.get(rSum));
            } else{
                map.put(rSum,i);
            }
        }
        return max;
    }
}