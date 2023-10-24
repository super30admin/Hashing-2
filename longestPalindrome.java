import java.util.HashSet;

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// Element is added into a Hashset one by one

public class longestPalindrome {
    public static void main(String[] args) {
        String s = "abccccdd";
        HashSet<Character> hs = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                cnt += 2;
                hs.remove(s.charAt(i));
            } else {
                hs.add(s.charAt(i));
            }
        }

        if (hs.size() >= 1)
            System.out.println(cnt + 1);
        else
            System.out.println(cnt);
    }
}
