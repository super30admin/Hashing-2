#executed on leet code
#time complexity - O(n)
#space complexity - O(1)
class Solution:
    def longestPalindrome(self, s: str) -> int:
        pairs = 0
        unpaired_chars = set()
        
        for char in s:
            if char in unpaired_chars:
                pairs += 1
                unpaired_chars.remove(char)
            else:
                unpaired_chars.add(char)
        
        return pairs * 2 + 1 if unpaired_chars else pairs * 2
        