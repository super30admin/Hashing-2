// Space time - o(n)
// Running sum method - calculate the runing some at each index and keep the max element of current max and i- revious sum in hashmap.
// Otherwise add that new rSum to hashmap. map.put(0,-1) should be edge case to read first 2 element array.
class Solution {
    public int findMaxLength(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap();
        int rSum = 0;
        int max = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            rSum = nums[i] == 0 ? rSum - 1 : rSum + 1;
            if (map.containsKey(rSum)) {
                max = Math.max(max, i - map.get(rSum)); // imp i-map.get(rSum)
            } else {
                map.put(rSum, i);
            }
        }
        return max;

    }
}