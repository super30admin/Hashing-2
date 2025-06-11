
// Time Complexity : O(n), where n is the length of the input string `s`.
// Space Complexity : O(1), since the HashMap stores at most 52 entries (for upper and lower case letters).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// HashMap-based counting approach.
// We first build a frequency map of all characters in the string.
// For each character:
//    - If its frequency is even, we can use all occurrences in the palindrome (count += freq).
//    - If the frequency is odd, we can use freq - 1 characters to maintain symmetry (count += freq - 1).
//      We also mark a flag to indicate at least one character with odd frequency exists.
// If any character has an odd count, we can place one such character at the center of the palindrome,
// so we add +1 to the final count.

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        //To track odd frequency element
        boolean flag = false;

        //Frequency Map
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //Loop the hash map to get the length
        for (char c : map.keySet()) {
            int freq = map.get(c);
            //If even increment the count by 2
            if (freq % 2 == 0) {
                count += freq;
            } else {//If odd
                flag = true;
                count += freq - 1;
            }
        }
        //If odd elements add one
        if(flag) count++;

        return count;
    }
}