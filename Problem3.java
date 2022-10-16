// Time Complexity : 13ms (faster than 27.98% of java submissions)
// Space Complexity : 42.4MB (less than 42.37 Submissions)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach

class Solution {
    public int longestPalindrome(String s) {

        int total = 0;
        boolean allow = true;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);

            }
        }

        for (int val : map.values()) {
            if (val % 2 == 0) {
                total += val;
            } else {
                if (allow) {
                    total += val;
                    allow = false;
                } else {
                    total += val - 1;
                }
            }
        }

        return total;

    }
}