import java.util.HashSet;

// Time Complexity :O(N) because we traverse the whole string ones
// Space Complexity :O(1) because we use HashSet and in worst case set can save 52 character - azAZ
// Did this code successfully run on Leetcode :Yes

// Any problem you faced1 while coding this :
public class LongestPalindrome {
	public int longestPalindrome(String s) {
        int result = 0;

        HashSet<Character> set = new HashSet<>();
        
        for(char c : s.toCharArray()){
          if(set.contains(c)){
            result+=2;
            set.remove(c);
          }
          else
        set.add(c);     
        }

        if(!set.isEmpty())
            result+=1;

    return result;
    }

}
