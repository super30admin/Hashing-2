import java.util.HashSet;
import java.util.Set;
//NEED HELP WITH FOLLOW UP QUESTION. PLEASE CHECK
/**
 * Author : Shubhangi
 * Leetcode : 409
 * TC: O(n)
 * SC: O(1)
 * Explanation: We iterate over all the char and add them to a set if they're already not there.
 * If they are present, then we increment count by 2 and remove them from the set. As we can add one single char 
 * in a palindromic string, we will check if the sett is not empty, if yes, we incr count by 1 and return  it.
 * Follow up Question: REturn a palindromic string that can be formed along with the count.
 * Difficulty faced: Not able to figure out how to add the chars to the start and end of the StringBuilder Object
 *  */

class LongestPalindromeLength {

    public static void main(String args[]){
        String s = "abccccdd";
        LongestPalindromeLength obj = new LongestPalindromeLength();
        int ans = obj.longestPalindrome(s);
        System.out.println(ans);
    }
    public int longestPalindrome(String s) {
        if(s.length() == 0 || s == null) return 0;
        Set<Character> sett = new HashSet<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!sett.contains(ch)){
                sett.add(ch);
            } else if(sett.contains(ch)){
                count += 2;
                sett.remove(ch);
                // StringBuilder sb = new StringBuilder();
                // sb.insert(0, ch);
                // sb.insert(sb.length()-1, ch);
                // System.out.print(sb);
            }
        }
        if(!sett.isEmpty()){
            count += 1;
        }

        return count;
    }
}