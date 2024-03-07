#T.C. O(n)
#S.C. O(1)

class Solution:
    def longestPalindrome(self, s: str) -> int:
        #We will have a map with the number of characters and the time when it's occuring
        freq_set = set()
        count = 0

        for i in range(len(s)):
            if s[i] in freq_set:
                count += 2
                freq_set.remove(s[i])
            else:
                freq_set.add(s[i])

        if freq_set:
            count += 1
        return count
