# Time complexity: O(N), where n is the length of characters in the string
# Space complexity: O(1)


class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashset = set()
        count = 0 

        for i in range(0, len(s)):
            ch = s[i]

            if ch in hashset:
                count = count + 2
                hashset.remove(ch)
            else:
                hashset.add(ch)
        
        if len(hashset) != 0:
            count = count + 1
        
        return count
