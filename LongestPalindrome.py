#Time complexity: O(n)
#Space complexity: O(n)

class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashmap = {}
        count = 0
        for i in range(len(s)):
            if s[i] in hashmap:
                del hashmap[s[i]]
                count += 2 
            else:
                hashmap[s[i]] = 1
        if len(hashmap) != 0:
            count += 1 
        return count