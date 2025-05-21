"""
Count freq of each char.
For each char, add all even counts and at most one odd character becaue can go in center
Final len = sum of all even counts + 1 for odd
"""
"""
Time Complexity: O(n) — One pass to count and one to calculate result
Space Complexity: O(1) —  a-z, A-Z characters, so constant extra space
"""
from collections import Counter

class longestPalindrome:
    def longestPalin(self, s: str) -> int:
        count = Counter(s)
        length = 0
        odd_found = False

        for freq in count.values():
            length += freq // 2 * 2
            if freq % 2 == 1:
                odd_found = True

        return length + 1 if odd_found else length
    
if __name__=="__main__":
    s = "abccccdd"
    obj = longestPalindrome()
    print(obj.longestPalin(s))
