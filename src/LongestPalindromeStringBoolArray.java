// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I didnt face any problem while coding this.
import java.util.Arrays;
import java.util.HashSet;

public class LongestPalindromeStringBoolArray {
    public int longestPalindrome(String s) {
        boolean[] set =  new boolean[62];
        int count =0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(set[c -'A']){
                count+=2;
                set[c - 'A'] = false;
            } else {
                set[c - 'A'] = true;
            }
        }
        for(int i=0;i<62;i++){
            if(set[i]){
                count++;
                break;
            }
        }
        return count;
    }
}
