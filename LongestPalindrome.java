import java.util.*;

public class LongestPalindrome{
    public int longestPalindrome(String s) {
        
        Set<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){

            char ss = s.charAt(i);

            if(!set.contains(ss)){
                set.add(ss);
            }else{
                count+=2;
                set.remove(ss);
            }

        }

        if(!set.isEmpty()) count+=1;

        return count;
    }
}