# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# I have used HashMap to set the frequency of each letter and then traversed over the HashMap to check if it even or odd frequency
# If odd then adding 1 for the longest palindrome


class Solution:
    def longestPalindrome(self, s: str) -> int:
        if not s:
            return 0
        dict = {}
        counter = 0
        has_Odd = False
        for i in range(len(s)):
            if s[i] not in dict:
                dict[s[i]] = 1
            else:
                dict[s[i]] += 1

        for str in dict:
            if dict[str] % 2 == 0:
                counter += dict[str]
            else:
                counter += dict[str] - 1
                has_Odd = True
        return counter + 1 if has_Odd == True else counter

#Time - O(N)
#Space - O(1)