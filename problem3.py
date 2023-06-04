#Time Complexity : O(1) ... n is number of elements 
#Space Complexity : O(n)
#Any problem you faced while coding this : no

#for eevery character, it was added to the set and whenever we find its even occurrence, it was removed from the set. Lastly, if there are odd occurrences, only one entry was counted.

class Solution:
    def longestPalindrome(self, s: str) -> int:
        checkSet = set()
        count = 0
        for ch in s:
            if ch not in checkSet:
                checkSet.add(ch)
            else:
                checkSet.remove(ch)
                count += 2

        if checkSet:
            return count + 1
        else:
            return count