# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = 0
        new_set = set()

        for i in range(len(s)):
            c = s[i]

            if c in new_set:
                count+=2
                new_set.remove(c)
            else:
                new_set.add(c)
        
        if new_set:
            count+=1
        
        return count

sc = Solution()
s = "abccccdd"
print(sc.longestPalindrome(s))