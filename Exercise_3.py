# Time Complexity : O(n) where n = len(s)
# Space Complexity : O(1) auxiliary (at most one entry per letter, fixed alphabet)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No issues

class Solution:

    def longestPalindrome(self, s: str) -> int:
        
        char_set = set()
        res = 0

        for i in s:
            if i in char_set:
                char_set.remove(i)
                res += 2
            else:
                char_set.add(i)

        if char_set:
            res += 1

        return res


if __name__ == "__main__":

    sol = Solution()
    # Example 1
    print(sol.longestPalindrome("abccccdd"))  # expected 7
    # Example 2
    print(sol.longestPalindrome("a"))         # expected 1
    # Additional tests
    print(sol.longestPalindrome("bb"))        # expected 2
    print(sol.longestPalindrome("Aa"))        # expected 1 (case-sensitive)
    print(sol.longestPalindrome("abcba"))     # expected 5