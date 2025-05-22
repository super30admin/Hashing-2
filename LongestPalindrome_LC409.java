import java.util.HashMap;
import java.util.HashSet;

/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time complexity - O(n)
Space complexity - O(1)
 */

public class LongestPalindrome_LC409 {

    public int longestPalindrome(String s) {
        HashMap<Character, Integer>countMap = new HashMap<>();
        for(Character ch: s.toCharArray()){
            countMap.put(ch, countMap.getOrDefault(ch,0)+1);
        }
        int res = 0;
        boolean hasOddFrequency = false;
        for(int freq:countMap.values()) {
            //if freq is even
            if((freq%2) ==0) {
                res+=freq;
            } else {
                //if frequency is odd then only one occurance of the character will remain without a match
                res+= freq-1;
                hasOddFrequency = true;
            }
        }
        //if hasOddFrequency is true that means we have atleast one unmatched char to make the center of an odd length palindrome.
        if(hasOddFrequency) return res +1;
        return res;
    }



//Approach 2
//Time complexity - O(n)
//Space complexity - O(1)

    public int longestPalindromeApproach2(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i =0 ;i< s.length(); i++) {

            char ch = s.charAt(i);
            if(set.contains(ch)) {
                count +=2;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        if(!set.isEmpty()) count++;
        return count;
    }
}
