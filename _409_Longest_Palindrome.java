/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// So the concept is if have even number of occurrence of character they can form a palindrome, if odd the occurrence - 1 would give us even so they can form a palindrome too, but only odd values can also give a palindrome, so if we found a odd count we change the flag and add count-1, at the end if the flag is true that means we found a odd count , that should be included in the ans, so we increment the answer and return it.

/**** Method 2 ****/
//Time Complexity: O(n)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

// Same concept as Method 1 but we can use constant space as only lowercase and uppercase are characters present in the string. Rather than a HashMap we can use a frequency arr of 63 length and do char c -'A' to fill the array.

import java.util.HashMap;
import java.util.Map;

public class _409_Longest_Palindrome {

  public int longestPalindrome1(String s) {
    HashMap<Character, Integer> map = new HashMap<>();

    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    boolean flag = false;
    int ans = 0;

    for (Map.Entry<Character, Integer> k : map.entrySet()) {
      int val = k.getValue();
      if (val % 2 == 0) {
        ans += val;
      } else {
        ans += (val - 1);
        if (!flag) flag = true;
      }
    }

    if (flag) return ans + 1;
    return ans;
  }

  public int longestPalindrome2(String s) {
    int[] count = new int[63];
    for (char c : s.toCharArray()) {
      count[c - 'A']++;
    }

    boolean flag = false;
    int ans = 0;

    for (int val : count) {
      ans += (val / 2) * 2;
      if (!flag && val % 2 != 0) {
        ans++;
        flag = !flag;
      }
    }
    return ans;
  }
}
