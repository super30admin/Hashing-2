// TC SC O(n)

class Solution {

    public int subarraySum(int[] nums, int k) {

        // Map to store Prefix Sum as keys and frequency of subarrays with prefixSum in the array as values
        HashMap<Integer,Integer> map= new HashMap<>();

        // to handle edge case where subarray size is 0 and it has occured once
        map.put(0,1);

        //our returning variable
        int count=0;

        //prefix sum at each num
        int prefixSum=0;
        
        for(int num: nums){

            prefixSum+= num;
            //if subarrays with (sum-k) has already occured previously then increment our count
            if(map.containsKey(prefixSum-k)){
                count+= map.get(prefixSum-k);
            }
            //if not then increment the frequency of the current prefixSum in map and if is not present take default 0
            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}