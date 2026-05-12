// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will use a hashmap to count the frequency of each character in the string.
// Then, we will calculate the length of the longest palindrome that can be formed
// using these characters. We will add the count of each character to the result. If the count is even, we can use all of them. If the count is odd, we can use all but one of them. Finally, if there is at least one character with an odd count, we can add one more character to the result to make it a palindrome.

class Solution {
    public int longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int result = 0;
        int temp = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < c.length; i++) {
            if (!(map.containsKey(c[i]))) {
                int count = 1;
                map.put(c[i], count);
            } else {
                int count = map.get(c[i]);
                count = count + 1;
                map.put(c[i], count);
            }
        }

        for (int value : map.values()) {
            if (value % 2 == 0) {
                result = result + value;
            } else {
                value = (value / 2) * 2;
                temp = 1;
                result = result + value;
            }

        }
        return (temp == 1) ? result + 1 : result;
    }
}