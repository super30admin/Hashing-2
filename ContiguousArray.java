// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Didnt understand the logic well.

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> Map= new HashMap<>();
        Map.put(0,-1);
        int sum=0;
        int length=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                sum=sum-1;
            }else{
                sum=sum+1;
            }
            if(Map.containsKey(sum)){
                length=Math.max(length,i-Map.get(sum));
            }
            else{
            Map.put(sum, i);
            }     
        }
        return length;
    }
}
