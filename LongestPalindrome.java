/**
Time Complexity - O(N) where N is the size of the input string S
Space complexity - O(1)
*/
class Solution {
    public int longestPalindrome(String s) {
        
        int[] charCount = new int[58];
        int len = 0;

        for(char c : s.toCharArray())
            charCount[c - 'A']++;

        for(int i = 0; i < charCount.length; i++)
            if(charCount[i] != 0){
                if(charCount[i] % 2 == 0)
                    len += charCount[i];
                else if(charCount[i] - 1 > 0){
                    len += charCount[i] - 1;
                }
            }

        if(s.length() - len > 0) 
            len++;

        return len;
    }
}
