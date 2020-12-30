// Time Complexity: O(N)
// Space Complexity: O(1)
// Did it run successfully on Leetcode? YES
class Solution {
    public int longestPalindrome(String s) {
       int[] charCount = new int[128];   
        int result = 0;
       for (char c: s.toCharArray())
       {
           if (++charCount[c] == 2)
           {
               result = result + 2;
               charCount[c] = 0;
           }
       }
      
       return result == s.length() ? result : result + 1;
    }
}
