"""
    Problem Statement: Given a string s which consists of lowercase or uppercase letters,
                       return the length of the longest palindrome that can be built 
                       with those letters.

    Approach: Loop over the characters in the input string and store the character
              in the hash set. If a repeat character is seen add 2 to the count and
              remove the character from the hash set.

    Time complexity: O(n)

    Space complexity: O(n)

    Accepted on LeetCode? Yes! 

    LeetCode Link: https://leetcode.com/problems/longest-palindrome
"""
class Solution:
    def longestPalindrome(self, s: str) -> int:
        mapper ,count = set(), 0
        for c in s:
            if c not in mapper:
                mapper.add(c)
            else:
                count += 2
                mapper.remove(c)
        
        return count + 1 if len(mapper) else count

if __name__ == "__main__":
    sol = Solution()
    s = "a"
    ret = sol.longestPalindrome(s)

    assert ret == 1