// Time- o(n) Space -o(n)
// Keep running sum, calculate the compliment at each step- check if present in map is yes get that value and increase count.
// if not add running sum to map and continue untill last element and return count.
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap();
        int rSum = 0;
        int count = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            rSum += nums[i];
            int compliment = rSum - k;
            if (map.containsKey(compliment)) {
                count += map.get(compliment);
            }
            if (!map.containsKey(rSum)) {
                map.put(rSum, 1);
            } else {
                map.put(rSum, map.get(rSum) + 1);
            }
        }
        return count;
    }
}