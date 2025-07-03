//Time Complexity - O(n)
//Space Complexity - O(1) as there will be finite set of alphabets

// Implemented using a HashSet to find the longest palindrome. While iterating through the string if charcter
// is already present in the HasSet add 2 to the count and remove the existing one if not add the chracter to the set
// if set contains chracters add 1 to the count.
import java.util.HashSet;

public class FindLongestPalindrome {

    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i< s.length(); i++) {
            char ch = s.charAt(i);

            if(set.contains(ch)) {
                count += 2;
                set.remove(ch);
            } else {
                set.add(ch);
            }

        }
        if(!set.isEmpty()) {
            count += 1;
        }

        return count;
    }
}
