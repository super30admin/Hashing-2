'''
Time complexity: O(n)
Space complexity: O(1)
'''
class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = 0
        hashmap = set()

        for i in range(len(s)):
            if s[i] in hashmap:
                count += 2
                hashmap.remove(s[i]) 
            else:
                hashmap.add(s[i])
        if not (hashmap==set()):
            count += 1
        return count
