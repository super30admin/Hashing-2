import java.util.HashMap;
// Time Complexity : O(n), where n is the length of the input string
// Space Complexity : O(1), since the maximum number of unique characters is bounded (only 52 uppercase/lowercase letters possible)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No major issues, just had to carefully handle odd counts

// Your code here along with comments explaining your approach:
// - We use a HashMap to count frequency of each character.
// - For each character frequency:
//     - If it's even, we can use all of them in the palindrome.
//     - If it's odd, we can use (count - 1) characters (i.e., the largest even subset of them).
// - We can have **at most one** odd character in the middle of the palindrome.
// - So, if we had at least one odd-count character, we add 1 to the final count to place that in the center.


public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        boolean flag = false;
        //count frequency of each character
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        //if count of each character is even they can used fully
        //if count is odd we decrement it by 1 and set the flag to true
        int count = 0;
        for (char c : map.keySet()) {
            int value = map.get(c);
            if (value % 2 == 0) {
                count += value;
            } else {
                flag = true;
                count += (value - 1);
            }
        }
        // If there was at least one odd character, we can place one in the center
        if (flag) {
            return count + 1;
        }
        return count;
    }

    // Main method to test
    public static void main(String[] args) {
        LongestPalindrome obj = new LongestPalindrome();
        String input = "abccccdd";
        int result = obj.longestPalindrome(input);
        System.out.println("Longest Palindrome length: " + result); // Output: 7
    }
}
