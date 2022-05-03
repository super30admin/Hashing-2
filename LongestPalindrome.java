// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        //ASCII value is used as arr index and count is increased
        for (char c: s.toCharArray())
            count[c]++;

        int result = 0;
        int odd =0;
        for (int v: count) {
            if(v % 2 != 0){
                odd =1;
                result += (v-1);
            }
            else{
                result += v;
            }
        }
        return result+odd;
    }
}
