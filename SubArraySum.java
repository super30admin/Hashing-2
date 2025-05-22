/* Problem 1:
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yes
*/

class SubArraySum {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int count = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, 0);
            }
            map.put(sum, map.get(sum) + 1);

        }

        return count;

    }
}