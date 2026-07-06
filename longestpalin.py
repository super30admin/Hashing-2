class Solution:
    def longestPalindrome(self, s: str) -> int:
        set_chars = set()
        count = 0

        for c in s:
            if c in set_chars:
                count += 2
                set_chars.remove(c)
            else:
                set_chars.add(c)

        if len(set_chars) > 0:
            return count + 1
        return count

# TC = O(n)
# SC = O(k) or O(1) based on hashset size i.e fixed set of characters.