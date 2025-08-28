// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Idea is to count the frequency of each character in the string
using hashset we add every character in set and when same character is inserted we create a pair and remove them from set
when set is not empty it contains only unpaired characters
*/
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            // if set already contains the character then we have found a pair 
            if(charSet.contains(ch)) {
                count += 2;
                charSet.remove(ch);
            } else {
                charSet.add(ch);
            } 
        }
        //if my set contains single elements only
        if(!charSet.isEmpty()) {
            count += 1;
        }
        return count;
    }
}
