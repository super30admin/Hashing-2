// Time Complexity : O(n)
// Space Complexity : O(1) // O(26)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : count increment by 2; I've incremented by 1.


/*
Maintain character char. If it reappears then remove it and add string length 2
Towards the bottom, if set is not empty then there are some characters which are appearing once so add +1
*/

import java.util.Set;
import java.util.HashSet;

public class LongestPalindrom {
    public int longestPalindrome(String s) {
        if(s == null | s.length() == 0) return -1;
        int maxlen = 0;

        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
            }else{
                maxlen += 2;
                set.remove(c);
            }
        }
        if(!set.isEmpty())
            maxlen = maxlen+1;


        System.out.println("Length : " + maxlen);
        return maxlen;
    }


    public static void main(String[] args) {
        LongestPalindrom lp = new LongestPalindrom();

        lp.longestPalindrome("abccccdd");
        lp.longestPalindrome("1");
        lp.longestPalindrome("a");
        lp.longestPalindrome("abd");

    }
}
