// Time Complexity : O(n)
// Space Complexity : O(52) = O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use a hashet here to count even numbered characters in string. Whenever we see even numbered characters, we add 2 to the count. 
   In the end if the hashset is still not empty, that means we have some odd numbered characters in the string. We can use one of
   them as a middle character of palindrome string so increase count by 1.
*/

class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        Set<Character> hSet = new HashSet<>();
        for(char c : s.toCharArray()) {
            if(hSet.contains(c)) {
                count += 2;
                hSet.remove(c);
            } else
                hSet.add(c);
        }
        if(!hSet.isEmpty())
            count += 1; 
        
        return count;
    }
}