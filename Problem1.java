// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will use a hashmap to store the cumulative sum and its frequency. We will iterate through the array and calculate the cumulative sum. If the cumulative sum is already present in the hashmap, it means that there is a subarray with sum equal to k. We will add the frequency of this cumulative sum to the result. If the cumulative sum is not present in the hashmap, we will add it to the hashmap with frequency 1.

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int rSum = 0;
        int count =0;
        for(int i = 0; i < nums.length; i++){
            rSum = rSum + nums[i];
            if(!(map.containsKey(rSum))){
                map.put(rSum,1);

            }else{
                map.put(rSum,(map.get(rSum)+1));
            }

        }
for(int a : map.keySet()){
    if(map.containsKey(a - k) ){
        count = count + map.get(a);
    }
}
return count;
        
    }
}