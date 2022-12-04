public class Longest_Palindrome {
    // Time: O(n), Space: O(1)
    public int longestPalindrome(String s) {
        int charCount[] = new int[128];
        int ans = 0;

        for (char c : s.toCharArray())
            charCount[c]++;

        for (int count : charCount) {
            ans += count / 2 * 2;
            if (ans % 2 == 0 && count % 2 == 1)
                ans++;
        }
        return ans;
    }
}
