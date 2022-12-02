# // Time Complexity : O (n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# if we encounter a char that is already in our char set , then add 2 to the res and remove that element from set
## if it is not there then add it to the set

#at the end , if the set has elements then add 1 to res


class Solution:
    def longestPalindrome(self,s):

        char = set()
        res = 0
        for i in range(len(s)):
            if s[i] in char:
                res+=2
                char.remove(s[i])
            else:
                char.add(s[i])
        if char:
            res+=1
        return res

