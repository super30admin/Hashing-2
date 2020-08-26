# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution(object):
    def longestPalindrome(self, s):
        pal = set()
        count = 0
        for i in s:
            if i not in pal:
                pal.add(i)
            else:
                count += 2
                pal.remove(i)
        if len(pal) > 1:
            return count + 1
        return count


s = Solution()
print s.longestPalindrome('abccccdd')