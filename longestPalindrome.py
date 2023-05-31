# Time Complexity : O(n)
# Space Complexity :O(1)
# Leet Code: Yes
# Used the approach of running sum

class Solution:
    def longestPalindrome(self, s: str) -> int:
        if len(s) == 0:
            return 0
        
        hashset = set()
        count = 0

        for char in s:
            if char not in hashset:
                hashset.add(char)
            else:
                count += 2
                hashset.remove(char)
        
        if len(hashset) == 0:
            return count
        else:
            return count+1