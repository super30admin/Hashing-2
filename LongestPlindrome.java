//Time Complexity = O(n)
//Space Complexity = O(1)
import java.util.*;
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> hash = new HashSet<>();
        int count=0;
        char[] charArray = s.toCharArray();
        for(int i=0;i<charArray.length;i++){
            if(!hash.contains(charArray[i])){
                hash.add(charArray[i]);
            }else{
                count=count+2;
                hash.remove(charArray[i]);
            }
        }
        if(!hash.isEmpty())
            count++;
        return count;
    }
}