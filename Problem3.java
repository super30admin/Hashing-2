// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.*;

class Problem3 {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                count = count + 2;
            } else {
                set.add(s.charAt(i));
            }
        }

        if (set.size() > 0) {
            count = count + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Problem3 obj = new Problem3();
        String s1 = "abccccdd";
        System.out.println(obj.longestPalindrome(s1)); // Output: 7
        String s2 = "a";
        System.out.println(obj.longestPalindrome(s2)); // Output: 1
    }
}