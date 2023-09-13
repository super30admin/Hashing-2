
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int count = 0;
        java.util.HashSet<Character> set = new java.util.HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                set.remove(c);
                count += 2;
            } else {
                set.add(c);
            }
        }
        if(!set.isEmpty()) {
            return count+1;
        } return count;
    }
}
