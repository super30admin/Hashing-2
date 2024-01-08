// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> Map= new HashMap<>();
        Map.put(0,1);
        int sum=0;
        int count =0;
        for(int i=0; i<nums.length;i++){
            sum+=nums[i];
            if(Map.containsKey(sum-k)){
                count=count+Map.get(sum-k);
            }
            if(!Map.containsKey(sum)){
                Map.put(sum,0);
            }
            Map.put(sum,Map.get(sum)+1);
        }
        return count;
    }
}
