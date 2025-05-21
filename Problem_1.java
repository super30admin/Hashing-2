/*
 * Time Complexity - if n = length of string, then Time Complexity: O(n)
 * Space Complexity - Hashmap of size at most 52 (uppercase + lowercase letters), so Space Complexity: O(1)
 * Approach - for each character in string, I counted its frequency using a hashmap.
 * If frequency is even, I added all to result. If frequency is odd, I added count - 1 to result
 * and set a flag that odd character is present. At the end, if any odd character was present, I added 1
 * to result (can be placed in center of palindrome).
 * 
 * This code worked successfully on Leetcode.
 */

import java.util.HashMap;
import java.util.Map;

public class Problem_1 {
    static int longestPalindrome(String s) {
        int res = 0;
        boolean oddpresent = false;
        Map<Character, Integer> hashmap = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            if (hashmap.containsKey(ch)) {
                hashmap.put(ch, hashmap.get(ch) + 1);
            } else {
                hashmap.put(ch, 1);
            }
        }
        System.out.println(hashmap);
        for (Map.Entry<Character, Integer> entry : hashmap.entrySet()) {
            Character ch = entry.getKey();
            int count = entry.getValue();
            if ((count % 2) == 1) {
                res += count - 1;
                hashmap.put(ch, 1);
                oddpresent = true;
            } else {
                res += count;
            }
        }
        if (oddpresent) {
            res += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

}
