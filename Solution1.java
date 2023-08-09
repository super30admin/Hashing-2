import java.util.HashSet;

// TC : O(n)
// SC : O(n)
class Solution1 {
    public int longestPalindrome(String s) {

        HashSet<Character> set = new HashSet<Character>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                count = count + 2; //same chars aa
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
        if (!set.isEmpty()) {
            count = count + 1;
        }
        return count;

    }
}
