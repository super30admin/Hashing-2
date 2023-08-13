# Problem3 (https://leetcode.com/problems/longest-palindrome)
# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
class solution:
    def longestPalindrome(self, s):
        # variable to track number of palinfromes
        count = 0
        # hashset to track the letters in s
        hset = set()
        # iterate through the string
        for i in range(len(s)):
            # if letter present in hashset
            if s[i] in hset:
                # increase by 2 coz pair found
                count += 2
                # remove from hset (it can be seen again in the str)
                hset.remove(s[i])
            else:
                hset.add(s[i])
        # middle element of the palindrome for longest
        if len(hset) >= 1:
            count += 1
        return count


sol = solution()
s = "abccccdd"
print(sol.longestPalindrome(s))
