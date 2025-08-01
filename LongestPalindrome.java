import java.util.HashSet;
//Time Complexity: O(n)
//Space Complexity: O(n)
//HashSet is used to count same type - multiple character even count.
public class LongestPalindrome {
    public int longPalindrome(String s)
    {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(char c: s.toCharArray()){
            if(set.contains(c))
            {
                count += 2;
                set.remove(c);
            }
            else{
                set.add(c);
            }
        }
        if(set.size()>0) return count+1; // contains odd multiple character event.
        return count;
    }
}
