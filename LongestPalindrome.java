//Time Complexity: O(n),
//Space Complexity: O(1), constant size of HashSet as maximum no of unique characters can be 52
//Did this code successfully run on Leetcode : Yes

/*Approach:
1. For every first occurrence of a character add it to a set
2. For every second occurrence remove it from the set and increase the counter by 2 to track all the even occurrences of any character in the input string
3. At the end of string traversal, if the set is not empty, it means the string has odd occurrences of characters aswell. Add 1 to the result counter, to include any one character in the plaindrome.
 */
class Solution {
    public int longestPalindrome(String s) {

        HashSet<Character> set = new HashSet<>();
        int length=0;

        for(int i=0;i<s.length();i++){

            char c=s.charAt(i);
            if(set.contains(c)){

                length+=2;
                set.remove(c);
            }
            else
                set.add(c);

        }

        return set.size()>0?length+1:length;
    }
}