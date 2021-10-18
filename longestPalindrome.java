/**
 * Leet Code 409
 */
class Solution {
    public int longestPalindrome(String s) {
        Set<Character> mySet = new HashSet<Character>();
        int totalPairs=0;
        int lengthLongestPalindrome=0;
        //Create hash set inserting each character in input string
        for(int i=0;i<s.length();i++)
        {
            if(!mySet.contains(s.charAt(i)))
            {
                mySet.add(s.charAt(i));
            }
            else
            {
                mySet.remove(s.charAt(i));
                lengthLongestPalindrome = lengthLongestPalindrome+2;
            }
        }
        //finally if any character with value 1 then add that single instance as middle element
        if (!mySet.isEmpty())
            lengthLongestPalindrome = lengthLongestPalindrome+1;
        return lengthLongestPalindrome;   
    }
}