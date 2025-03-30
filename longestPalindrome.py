"""
Approach: 
I solved this using a greedy approach with a set.
we will iterate through the string and if there no occrance we add the char to the set
else we know that is already in the set. we increment the count by 2 and we remove the char from the set
if still there are ant chars in the set, then we can create a odd num of palindrome like "aba". so we increment the count by 1
in the end we return count which gives the longest palindrome

Time Complexity: O(n)

Space Complexity: O(n)

Passed in Leetcode: Yes

Any difficulties: No

"""
class Solution:
    def longestPalindrome(self, s: str) -> int:
        stringSet = set()
        count = 0

        for s_char in s:
            if s_char not in stringSet:
                stringSet.add(s_char)
            else:
                count += 2
                stringSet.remove(s_char)
        if stringSet:
            count += 1
        return count


sol = Solution()
s = "abccccdd"
print(sol.longestPalindrome(s))
