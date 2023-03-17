// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0,1);
        for(int i = 0;i<nums.length;i++){
            sum = sum+nums[i];
            if (map.containsKey(sum-k)){
                count = count + map.get(sum-k);
            }
            if (map.containsKey(sum)){
                int newcount = map.get(sum);
                newcount++;
                map.put(sum,newcount);
            }
            else{
                map.put(sum,1);
            }


        }
        return count;
    }
}