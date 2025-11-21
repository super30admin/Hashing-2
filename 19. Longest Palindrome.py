class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = 0 
        checker = set()

        for chr in s: 
            if chr not in checker:
                checker.add(chr)
            else:
                checker.remove(chr)
                count += 2
        if len(checker)>0:
            count += 1
        return count
        