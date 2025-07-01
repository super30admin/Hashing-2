// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// I used a HashMap to count the frequency of each character in the input string.
// For every character with even frequency, I added the full count to the result.
// For characters with odd frequency, I added (count - 1), and used a flag to remember
// if we can place one odd character in the center of the palindrome.
// If there was at least one odd count, I added 1 to the final length for the center.

import java.util.HashMap;

public class longestPalindrome {
    public int solve(String s){
        if(s.length()==0 || s==null){
            return 0;
        }
        HashMap<Character, Integer> hmap = new HashMap<>();
        int l=0;
        boolean flag = false;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(hmap.containsKey(ch)){
                hmap.put(ch, hmap.get(ch)+1);
            }
            else{
                hmap.put(ch, 1);
            }
        }

        for(int count: hmap.values()){
            if(count%2==0){
                l+=count;
            }
            else{
                l+=count-1;
                flag=true;
            }
        }

        if(flag){
            return l+1;
        }
        else{
            return l;
        }


    }
    public static void main(String[]args){
        longestPalindrome ob = new longestPalindrome();
        String s1 = "abccccdd";
        String s2 = "a";
        System.out.println("Longest Palindrome has the length: "+ob.solve(s1));
        System.out.println("Longest Palindrome has the length: "+ob.solve(s2));
    }
}
