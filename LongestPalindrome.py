#Time Complexity : O(n))
#Space Complexity : O(n) for dictionary, although we can use a hashset for O(1) space complexity, not sure how to do it in python
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : I am not sure why but leet code said I am only in the 30th percentile for time complexity and
#8th percentile for space


class Solution:
    def longestPalindrome(self, s: str) -> int:
        countChecker = {}
        result = 0
        for letter in s:
            if letter in countChecker:
                countChecker[letter] += 1
            else:
                countChecker[letter] = 1

            if countChecker[letter] == 2:
                del countChecker[letter]
                result += 2

        if len(countChecker) > 0:
            return result + 1
        else:
            return result