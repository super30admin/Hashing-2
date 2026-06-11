
// Time complexity O(n)
// Space complexity O(n)
// A subarray of sum k can be found by keeping track of running sum and its freaquency in a hash map
// if rSum-k is present in the map. increase the count by frequency of rSum-k
class Problem3 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> rSumMap =   new HashMap<>();
        int rSum = 0;
        int count = 0;
        rSumMap.put(0,1); // place dummy value to handle where nums[i] = k
        for(int i=0; i<nums.length; i++) {
            rSum += nums[i];
            if(rSumMap.containsKey(rSum-k)) {
                count = count + rSumMap.get(rSum-k);
            }
            if(rSumMap.containsKey(rSum)){
                rSumMap.put(rSum,rSumMap.get(rSum)+1);
            } else {
                rSumMap.put(rSum,1);
            }
        }
        return count;
    }
}