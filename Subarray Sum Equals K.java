// as we only need no.of subarrays, we can take a running sum and add them in hashmap 
//check if current running sum-target is present in hashmap, if so add the no.of occurances to count.

// Time Complexity O(n)
// Space complexity O(n)


class Solution {
    public int subarraySum(int[] nums, int k) {
        int count= 0;
        int rsum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        // Add a dummy 0 occurance to make problem
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            rsum = rsum + nums[i];
            int c = rsum-k;
            if(map.containsKey(c)){
                count = count + map.get(c);

            }

                map.put(rsum, map.getOrDefault(rsum,0) + 1);
        }
        return count;
    }
}
