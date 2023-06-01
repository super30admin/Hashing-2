// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int subarraySum(int[] nums, int k) {
        //base case
       if(nums.length==0 || nums==null)return 0;
       //key is runningsum and value is count of occurence of rsum
       HashMap<Integer,Integer> map = new HashMap<>();
       int rsum = 0;
       int count =0;
       map.put(rsum,1);//or map.put(0,1)[to handle [3,4] scenario for target 7]
       for(int i =0;i<nums.length;i++){
           rsum = rsum + nums[i];
           //increment count if you found key with (rsum - target)
           if(map.containsKey(rsum-k)){
               count = count + map.get(rsum - k);
           }
            // if(map.containsKey(rsum)){
            //     map.put(rsum,map.get(rsum)+1);
            // }
            // else{
            //     map.put(rsum,1);
            // }
                   map.put(rsum,map.getOrDefault(rsum,0)+1);
       }
return count;
    }
}