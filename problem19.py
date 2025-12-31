class Solution:
    def longestPalindrome(self, s: str) -> int:
        # here we can use a hashset, because just need to see if the char has occured before.
        sett = set()
        count = 0

        for i in range(len(s)):
            if s[i] in sett:
                count += 2
                sett.remove(s[i]) #O(1) avg due to hashing
            else:
                sett.add(s[i])

        # now check the remaining chars in the sett, we can just take one from it
        if len(sett) != 0:
            count += 1

        return count

# Time and Space: O(N)