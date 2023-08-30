import java.util.HashSet;
//TC:O(N) SC:O(N)
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> map = new HashSet<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.contains(ch)) {
                count += 2;
                map.remove(ch);
            } else {
                map.add(ch);
            }
        }
        if(map.size() >= 1) count += 1;
        return count;
    }
}
