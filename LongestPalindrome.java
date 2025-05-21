
//Time Complexity: O(n)
//Space Complexity: O(n)
//Approach: see number of pairs of characters are present, all of them can be part of palindrome (even length palindrome). 
// Lastly if there is atleast one charcter that's repeating once(or left out after 
//adding all of its pairs) then add 1(to form odd length palindrome)
import java.util.*;
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int res = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
            }
            else{
                res += 2;
                set.remove(ch);
            }
        }
        res += set.size()>0?1:0;
        return res;
    }
}