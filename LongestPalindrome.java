// TC: O(n)
// SC: Hashmap of size 52 (uppercase + lowercase) - O(1)
// Approach 1: Maintain HashSet and a count, add to set if it does not exist else increase count by 2
// and remove the character from set. Return count if set is empty (even plaindrome) else return count+1(odd palindrome)

// Approach 2: Maintain hashmap of character frequency.

import java.util.HashSet;

public class LongestPalindrome {
  public int longestPalindrome(String s) {

    HashSet<Character> set = new HashSet<>();
    int count = 0;

    for (char ch : s.toCharArray()) {
      if (set.contains(ch)) {
        count += 2;
        set.remove(ch);
      } else {
        set.add(ch);
      }
    }
    if (set.isEmpty()) {
      return count;
    }
    return count + 1;
  }

  public static void main(String[] args) {
    LongestPalindrome lp = new LongestPalindrome();
    String s = "abccccdd";

    System.out.println(lp.longestPalindrome(s));
  }
}