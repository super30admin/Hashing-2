import java.util.*;
class longest_palindrome {
    public static int longestPalindrome(String s) {
        int count = 0;
        HashSet<Character> set_chars = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(set_chars.contains(c)){
                count+=2;
                set_chars.remove(c);
            }
            else{
                set_chars.add(c);
            }
        }
        if(set_chars.isEmpty()) return count;
        else return count+1;
    }

    public static void main(String[] args) {
        System.out.println(longest_palindrome.longestPalindrome("abccccdd"));

    }
}