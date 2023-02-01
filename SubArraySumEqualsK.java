/**
 * Author: Shubhangi
 * TC: O(n)
 * SC: O(n)
 * Leetcode done: YEs
 * Problem Faced: the whole question was very tricky
 */
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String args[]){
        int arr[] = {1,1,1};
        int  k = 2;
        Solution obj = new Solution();
        int maxLength = obj.subarraySum(arr, k);
        System.out.println(maxLength);
    }
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 0)    return 0;    
        Map<Integer, Integer> map = new HashMap<>();
    map.put(0,1);
      int rsum = 0 , maxLength =0;
    for(int i = 0; i< nums.length; i++){
        rsum += nums[i];
        if(map.containsKey(rsum - k)){
            maxLength += map.get(rsum - k);
        } 
        if(!map.containsKey(rsum)){
            map.put(rsum, 0);
        } 
        map.put(rsum, map.get(rsum) +1);
         }
            return maxLength;
    }
}
