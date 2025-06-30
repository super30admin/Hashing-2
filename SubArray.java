//TC - O(n)
// SC - O(n)

// To find number of subarrays we maintain a counter 
// and increase it when running sum - target is available in map already.
class SubArray {
    public int subarraySum(int[] nums, int k) {
        
        // base case
        if(nums==null || nums.length==0){
            return 0;
        }

        int rSum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // adding inital values in map to cover edge case
        map.put(0,1);
        for(int num : nums){
            rSum += num;
            if(map.containsKey(rSum-k)){
                count = count + map.get(rSum-k);
            }

            // this line enters the value in map for loop either way
            map.put(rSum, map.getOrDefault(rSum, 0) +1 );
        }

        return count;
    }
}