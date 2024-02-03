//The algorithm counts the number of subarrays in the array nums whose sum equals the target k.
// It uses a running sum (rsum) and a HashMap (map) to store the cumulative sum frequencies. 
//For each index, it calculates the difference y between the running sum and the target k. 
//If y is present in the HashMap, it increments the count by the frequency of y. 
//time complexity of O(n) , space complexity of O(n) 
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count =0, rsum =0;
        HashMap<Integer, Integer> map  = new HashMap<>();
        map.put(0,1); // for intial balanced subarray
        for(int i=0;i<nums.length;i++){
            rsum += nums[i];
            int y = rsum-k;
            if(map.containsKey(y)){
                count += map.get(y);
            }
            if(!map.containsKey(rsum)){
                map.put(rsum,1);
            }
            else map.put(rsum, map.get(rsum)+1);
        }

        return count;
        
    }
}