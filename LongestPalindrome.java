package day7;
//Time Complexity - O(n)
//Space Complexity - O(1)
//Ran in Leetcode - Yes
import java.util.HashSet;

public class LongestPalindrome {
	public static int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int longestPalindrome =0;
        for(int i= 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                set.remove(ch);
                longestPalindrome = longestPalindrome+2;
            }
            else
                set.add(ch);
        }
        if(!set.isEmpty())
            longestPalindrome++;
        return longestPalindrome;
    }
	public static void main(String[] args) {
		int output = longestPalindrome("abccccdd");
		System.out.println(output);
	}

}
