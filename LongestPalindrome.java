import java.util.HashMap;

public class LongestPalindrome {

    // Time Complexity : O(N) - N is length of string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

    public int longestPalindrome(String s) {
        if(s.length()==1) return 1;
        int result=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                if(map.get(s.charAt(i)) == 1) {
                    result = result+2;
                    map.remove(s.charAt(i));
                }
            }
        }
        if(!map.isEmpty()) result = result+1;
        return result;
    }
}
