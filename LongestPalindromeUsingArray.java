// Time Complexity : O(n), where n is the length of the input string `s`.
// Space Complexity : O(1), because the array `set` has a fixed size (constant space).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// Array-based pairing approach.
// The idea is to use a fixed-size array `set` to simulate character pairing.
// - We use `char[] set = new char[100]` to hold seen characters using index `c - 'A'`.
// - When a character appears for the first time, we store it in the array.
// - When it appears again (i.e., a pair is found), we increment `count` by 2 and reset the position to 0.
// - After processing the entire string, if `count == s.length()`, all characters formed pairs, return `count`.
// - Otherwise, we can place one unpaired character in the center, so return `count + 1`.

class Solution {
    public int longestPalindrome(String s) {
        char[] set = new char[100];
        int count = 0;

        for (char c : s.toCharArray()) {
            if(set[c-'A'] != 0){
                count+=2;
                set[c-'A'] = 0;
            }else{
                set[c-'A'] = c;
            }
        }

        //Odd check
        if(s.length() == count) return count;
        return count+1;
    }
}