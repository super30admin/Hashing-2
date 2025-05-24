# Time Complexity: O(n)
# Space Complexity: O(n)
from collections import Counter

def longestPalindrome(s: str) -> int:
    char_count = Counter(s)
    length = 0
    odd_found = False
    
    for count in char_count.values():
        length += count // 2 * 2
        if count % 2 == 1:
            odd_found = True
    
    return length + 1 if odd_found else length
