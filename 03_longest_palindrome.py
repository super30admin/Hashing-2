# // Time Complexity : O(n) because only once we iterate
# // Space Complexity : O(n) because hashMap can be created of size n, having n different prefixSums
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution:
    def longestPalindrome(self, s: str) -> int:
        if len(s) == 0:
            return 0
        if len(s) == 1:
            return 1
        hashMap = collections.defaultdict(int)
        
        for ch in s:
            hashMap[ch] += 1
        
        maxLen = 0
        flag = True
        for value in hashMap.values():
            #if the frequency is even directly add to the len
            if(value % 2 == 0):
                maxLen += value
            else:
                if flag: #ie we get odd count for the 1st time
                    flag = False
                    maxLen += value
                else:
                    maxLen += (value-1)
        return maxLen
                