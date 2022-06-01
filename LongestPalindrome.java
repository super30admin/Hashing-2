// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

public class LongestPalindrome {

    public int longestPalindrome(String s) {

        int[] a = new int[256];
        int count = 0;
        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)]++;
        }

        // Get count by dividing and multiply with 2 -> ccc
        for (int i : a) {
            count = count + ((i/2) * 2);
        }

        // Handling odd occurances
        return count == s.length() ? count : count + 1;

    }


}
