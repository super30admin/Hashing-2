"""
I go on adding items in the string and its occurences to a hashmap. In the second for loop I check for the length
of palindrome possible keeping in mind that an element can have even or odd occurences

Time Complexity : O(n) we are running two for loop each taking O(n) time
Space Complexity : O(n) since we are creating a hashmap of length 'n'
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced
"""
class Solution:
    def longestPalindrome(self, s: str) -> int:
        s = list(s)
        maps = defaultdict(str)

        for i in s:
            if maps[i]:
                maps[i] += 1
            else:
                maps[i] = 1

        count = 0
        odd = 0
        for i in maps.values():
            if i % 2 == 1:
                odd = 1
                count += i - 1
            else:
                count += i

        return count + odd