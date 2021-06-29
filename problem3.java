// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int longestPalindrome(String s) {

        int length = 0;
        int[] charCount = new int[128];

        for(char c: s.toCharArray()){
            charCount[c]++;
        }
        
        for(int i : charCount){
            length += i/2 * 2;

            if(length%2 == 0 && i%2 ==1){
                length++;
            }
        }
        return length;
    }
}
