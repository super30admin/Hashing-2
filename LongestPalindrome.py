//Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO




class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        hashset = set()
        count = 0
        for i in s:
            if i not in hashset:
                hashset.add(i)
            else:
                hashset.remove(i)
                count+=2
        if len(hashset)!=0:
            count+=1
        return count
                