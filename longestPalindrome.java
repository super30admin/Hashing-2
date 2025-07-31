// To find the longest palindrome from a string, I track how often each character appears using a Boolean array that maps ASCII values from 'A' to 'z'. As I iterate through the string, whenever I find a character that’s already been seen once—its Boolean flag is true—I know it's a complete pair, so I add 2 to the count and reset that flag. At the end, only the odd-frequency characters are left marked as true, and if my total count is still less than the string’s length, it means there’s at least one character that hasn’t been paired. In that case, I can add one extra character to the center of the palindrome, maximizing its length.

// this runs in O(n)  time complexity since we are iterating through the string where n is the length of the string.

 //the space run in constant time because the only additional data structure that we are using is of fixed length throughout the course of the problem. 
class Solution {
    public int longestPalindrome(String s) {
        boolean[] set = new boolean[58];
        char[] chars=s.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (set[c-'A']) {
                count+=2;
                set[c-'A']=false;
            } else
                set[c-'A']=true;
        }
        
        return (count<s.length()) ? count + 1 : count;
    }
}

