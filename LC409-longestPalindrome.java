import java.util.*;

class Solution {
    public int longestPalindrome(String s) {

        /**
        str = "abccccdd" 
        set a
        len = 0
        for each ch in str:
            if a not has ch: a.add(ch)
            else a.remove(ch), length += 2,

        if a is empty return length
        else length+1 
         */

         HashSet<Character> set = new HashSet<>();
         int len = 0;
         for (int i=0; i<s.length(); i++){
             char ch = s.charAt(i);
             if (!set.contains(ch)) set.add(ch);
             else {
                 len +=2;
                 set.remove(ch);
             }

         }

         if (!set.isEmpty()) len++;

         return len;
        
    }
}