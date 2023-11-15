// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

/* create a map and store the occurances of each string, if prsent already increase count */
/* after each specific entry check whether that freqency is divisble by 2 if so increase count by 2 as there will be two chars, at end all even charcters are counted*/
/* since palindrome if there are any elements with count 1 we can increase count and break */



import java.util.HashMap;

public class Problem3 {
        public static int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch) % 2 == 0){
                count = count + 2;
            }
        }
       for(char c : s.toCharArray()){
           if(map.get(c) % 2 != 0){
               count++;
               break;
           }
       }
        return count;
    }

    public static void main(String[] arg) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
}
