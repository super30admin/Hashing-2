//Time Complexity=O(n)
//Space Complexity=O(1)
import java.util.HashSet;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if(s==null ||s.length()==0)
            return 0;
        HashSet<Character> stringSet=new HashSet<>();
        int count=0;
        for(char c:s.toCharArray()){
            if(!stringSet.contains(c)){
                stringSet.add(c);
            }
            else {
                count+=2;
                stringSet.remove(c);
            }
        }
        return count + (stringSet.size() > 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome=new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("abccccdd"));
    }
}
