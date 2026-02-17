// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Sample {
    // time complexity O(n)
    // space complexity O(n)
    // ran successfully in leetcode
    // the logic keeps track of the prevous count and sum of the subarray
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> previousCount = new HashMap<>();
        previousCount.put(0, 1); // base case, if a sum of 0 is required in the future count increments by one

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            // if the sum difference is already there then calculate the
            if (previousCount.containsKey(sum - k)) {
                count += previousCount.get(sum - k);
            }
            // update the count
            previousCount.put(sum, previousCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }


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

    // time complexity O(n)
    // space complexity O(1) since there are only 26 characters
    // ran successfully in leetcode
    // the logic keeps adds in the set if character is not else removes it and adds 2 to the maxlength
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int len = 0;
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
                len += 2;
            } else {
                set.add(ch);
            }
        }
        return set.size() > 0 ? len + 1 : len;

    }
}
