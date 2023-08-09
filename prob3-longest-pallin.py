class Solution:
    def longestPalindrome(self, s: str) -> int:
        elements = list()
        count = 0

        for i in s:
            if i not in elements:
                elements.append(i)
            else:
                elements.remove(i)
                count += 2
        if elements:
            count += 1

        return count
    

