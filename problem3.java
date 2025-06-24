// Time Complexity : O(n)
// Space Complexity : O(1) because the array size is constant (52 for lowercase and uppercase letters)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: I made a character frequency array of size 52, where the first 26 indices are for lowercase letters and the next 26 indices are for uppercase letters.
// Core logic is that each palindrom will have even frequency of characters, except for one character which can have an odd frequency (to maximise).
// I iterate through the frequency array, adding the even frequencies to the result. I also keep track of whether there is at least one character with an odd frequency. If there is, then I add 1 to the result at the end, since we can use one odd frequency character in the middle of the palindrome.

class Solution {
    public int longestPalindrome(String s) {
        int[] freqArr = new int[52]; 
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                freqArr[c - 'a']++;
            } else {
                freqArr[c - 'A' + 26]++;
            }
        }
        int res = 0;
        boolean hasOdd = false;
        for (int n : freqArr) {
            if (n % 2 == 0) {
                res += n;
            } else {
                res += n - 1; 
                hasOdd = true; 
            }
        }
        return hasOdd ? res + 1 : res;
    }
}
