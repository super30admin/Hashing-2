/**
Problem: https://leetcode.com/problems/longest-palindrome/
TC: O(n)
SC : O(1) since hash map will have 26 key value pairs at max.
*/
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int maxLen = 0;
        boolean foundOdd = false;
        
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for(Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() % 2 == 0) {
                maxLen += e.getValue();
            } else {
                maxLen += (e.getValue() - 1);
                foundOdd = true;
            }
        }
        return (foundOdd ? maxLen + 1 : maxLen);
    }
}