# Time Complexity: O(N)
# Space Complexity: O(N)

class Solution:
    def longestPalindrome(self, s: str) -> int:
        freq = collections.defaultdict(lambda: 0)
        for char in s:
            freq[char] += 1
        
        res = 0
        odd_taken = False
        for frequency in freq.values():
            if frequency % 2 > 0:
                res += (frequency // 2) * 2
                if not odd_taken:
                    odd_taken = True
                    res += 1
            else:
                res += frequency
        
        return res


        
        
