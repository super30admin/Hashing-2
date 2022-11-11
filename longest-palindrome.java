// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//check every letter which repeats twice and increment count likewise
//if the hashmap exists, means we can choose a single element among it, so increment it by one.

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                count += 2;
                map.remove(c);
            } else {
                map.put(c, 1);
            }
        }
        if (map.size() > 0)
            count++;
        return count;
    }
}