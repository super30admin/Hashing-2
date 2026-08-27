//Time Complexity: O(n)
//Space Complexity: O(1)

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
    Set<Character> set;
    int result;
    public int longestPalindrome(String s) {
        set = new HashSet<>();
        result = 0;
        for(int i = 0; i< s.length();i++) {
            char curr = s.charAt(i);
            if(set.contains(curr)) {
                result += 2;
                set.remove(curr);
            } else {
                set.add(curr);
            }
        }
        if(set.size() != 0) {
            result +=1;
        }
        return result;
    }
}
