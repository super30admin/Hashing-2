// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        HashSet<Character> set = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.add(ch) == false) {

                set.remove(ch);
                count = count + 2;
                System.out.println(ch + " " + count);
            } else {
                set.add(ch);
            }
        }
        if (!set.isEmpty())
            count++;
        return count;
    }
}
