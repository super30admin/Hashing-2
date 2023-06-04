import java.util.HashSet;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if(s.length()==0 || s==null)
            return 0;
        HashSet<Character> set=new HashSet<>();
        int count=0;
        for(char c:s.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
            }else{
                count=count+2;
                set.remove(c);
            }
        }
        if(!set.isEmpty())
            count++;
        return count;
    }
}
