// Time Complexity : O(n) we loop through all characters of string s
// Space Complexity : O(1) we store upto 52 characters in the hashSet (all lowercase and uppercase letters)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem3 {
    public int longestPalindrome(String s) {

        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }

        }

        if(set.size() <= 1) return s.length();

        return s.length() - set.size() + 1;
    }
}
