// Time Complexity : O(N)
// Space Complexity : O(26) or O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :

import java.util.HashSet;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int sum=0;
        for(int i=0; i<s.length(); i++){
            if(set.contains(s.charAt(i))){
                sum = sum +2;
                set.remove(s.charAt(i));
            }else{
                set.add(s.charAt(i));
            }
        }
        if(set.isEmpty()){
            return sum;
        }
        return sum +1;
    }
}
