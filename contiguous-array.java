class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int rSum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                rSum--;
            } else {
                rSum++;
            }
            if (map.containsKey(rSum)) { //we are checking if the total sum is available in the hashmap, therefore z = x-y would give the longest length
                int curr = i - map.get(rSum);
                max = Math.max(max, curr);
            } else {
                map.put(rSum, i);
            }
        }
        return max;
    }
}

//TC: O(n)
//SC: O(1)