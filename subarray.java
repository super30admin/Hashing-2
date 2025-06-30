// We use a HashMap to store the frequency of running sums (rsum) encountered so far.
// For each element, we check if (rsum - k) exists in the map, meaning a subarray with sum k ends at the current index.
// We update the count accordingly and increment the frequency of the current rsum in the map.

//Time Complexity: O(n) – We traverse the array once.
//Space Complexity: O(n) – In the worst case, we store all running sums in the HashMap.


class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null|| nums.length == 0)
        {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int rsum = 0;
        int count = 0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            rsum += nums[i];
            if(map.containsKey(rsum - k ))
            {
                count+=map.get(rsum-k);
                
            }
            map.put(rsum,map.getOrDefault(rsum,0)+1);
        }
        return count;

        
    }
}