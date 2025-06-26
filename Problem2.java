// Time Complexity: O(n)
// Space Complexity: O(n)

// Using a running sum pattern and a hashmap to store first occurance of the runningSum

class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length == 1) return 0;

        HashMap<Integer, Integer> indexMap = new HashMap<>();

        int runningSum = 0;
        int max=0;
        indexMap.put(runningSum, -1); // initial state

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) runningSum--;
            else runningSum++;
            if (indexMap.containsKey(runningSum)) {
                max = Math.max(max, i - indexMap.get(runningSum));
            } else {
                indexMap.put(runningSum, i);
            }

        }
        return max;
    }
}
