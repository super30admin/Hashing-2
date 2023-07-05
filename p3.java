// Time Complexity : Time complexity would be O(n) as we have to iterate over the length
// Space Complexity : Space complexity would be O(1)
// Did this code successfully run on Leetcode :Yes

// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// I am using an array to see if the frequency of the letter is even or odd. Everytime the frequency becomes even ie 2, I update it to be 0 and increment my count by 2. At the end if there is any single element which has frequency one, I increment my count by 1 as that element can be at the center of the palindrome. The count is the length of the palindrome

class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[61];
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            int ind = s.charAt(i) - 'A';
            if (arr[ind] == 0) {
                arr[ind]++;
            } else {
                cnt = cnt + 2;
                arr[ind] = 0;
            }
        }

        for (int i = 0; i < 61; i++) {
            if (arr[i] == 1) {
                return ++cnt;
            }
        }

        return cnt;
    }
}