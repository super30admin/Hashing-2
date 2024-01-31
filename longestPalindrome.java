import java.util.HashSet;
/** Time Complexity : O(1)
 Space Complexity : O(1)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No


 Your code here along with comments explaining your approach **/

public class longestPalindrome {
    public int longestPalindrome(String s) {
        if (s==null || s.length()==0){//null check
            return -1;
        }
        int count =0;
        HashSet<Character> set = new HashSet<>();
        for (int i=0; i<= s.length()-1;i++){
            char c = s.charAt(i);
            if (set.contains(c)){//pairing
                count +=2;
                set.remove(c);
            }
            else {
                set.add(c);
            }
        }
        if (!set.isEmpty()){//adding last element
            count++;
        }
        return count;
    }
}
