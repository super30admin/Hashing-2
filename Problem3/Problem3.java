package Problem3;
import java.util.*;
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set= new HashSet<>();
        int count=0;
        for(char c: s.toCharArray()){
            if(set.contains(c)){
                count+=2;
                set.remove(c);
            }
            else{
                set.add(c);
            }
            
        }
        if(set.size()>0){
            return count+1;
        }
        else
        {
            return count;
        }
    }
}