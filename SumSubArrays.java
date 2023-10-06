// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int subarraySum(int[] nums, int k) {
       HashMap<Integer,Integer> map=new HashMap<>();
       int sum=0;
       int count=0;
       if(nums==null ||nums.length==0)return 0;
       map.put(0,1);
       for(int i=0;i<nums.length;i++){
           sum+=nums[i];
           int diff=sum-k;
           if(map.containsKey(diff)){
               count+=map.get(diff);
           }
           if(!map.containsKey(sum)){
               map.put(sum,1);
           }else{
               map.put(sum,map.get(sum)+1);
           }
       } 
       return count;
    }
}