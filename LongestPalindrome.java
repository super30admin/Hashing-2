//Time Complexity O(n)
//space = 0(1) constant because small characters
import java.util.HashSet;

class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> hset = new HashSet<>();
        int total = 0;
        for(int index = 0; index < s.length();index++)
        {
            char schar = s.charAt(index);
            if(hset.contains(schar))
            {
                total = total+2;
                hset.remove(schar);
            }
            else{
                hset.add(schar);
            }
        }
        if(!hset.isEmpty())
        {
            total = total + 1;
        }
        return total;
    }
}