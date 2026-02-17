import java.util.HashSet;

class LongestPalindrome {

    // time complexity O(n)
    // space complexity O(1) since there are only 26 characters
    // ran successfully in leetcode
    // the logic keeps adds in the set if character is not else removes it and adds 2 to the maxlength
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int len = 0;
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
                len += 2;
            } else {
                set.add(ch);
            }
        }
        return set.size() > 0 ? len + 1 : len;

    }
}