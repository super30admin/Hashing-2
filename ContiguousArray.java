import java.util.HashMap;
class ContiguousArray {

    // time complexity O(n)
    // space complexity O(n)
    // ran successfully in leetcode
    // the logic keeps track of the sum incrementing if 1 else decrementing
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0, sum = 0;
        map.put(0 , -1); // base case for sum 0

        for (int i = 0; i < nums.length; i++) {
            sum = (nums[i] == 1) ? sum + 1: sum - 1;
            if(map.containsKey(sum)) {
                maxLength = (i - map.get(sum) > maxLength) ? i - map.get(sum): maxLength;
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}