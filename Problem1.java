// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Use hash map to store the running sum and the frequency of running sum
calculate rSum - k if already seen before then we have found a valid subarray and increement the count
Count the number of times running sum appeared in hashMap
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        int count = 0;
        int rSum = 0;
        map.put(0,1);
        for(int i=0; i< nums.length; i++) {
            rSum += nums[i];
            int comp = rSum - k;
            //check if comp exists in map
            if(map.containsKey(comp)) {
                count = count + map.get(comp);
            }
            //checks if rSum already exists in map, if not make a new entry if yes, get the previous value and increement by 1
            if(!map.containsKey(rSum)) {
                map.put(rSum, 1);
            } else {
                map.put(rSum, (map.get(rSum)+1));
            }
        }
        return count;
    }
}
