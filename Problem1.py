# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

#itterating over each character in the string and adding the character to the set if it is not already present in the set. If the character is already present in the set, removing the character from the set and incrementing the count by 2. If the set is empty return the count else return count+1

class Solution:
    def longestPalindrome(self, s: str) -> int:
        HashSet=set()
        count=0
        strList=list(s)
        for st in strList:
            if st not in HashSet:
                HashSet.add(st)
            else:
                HashSet.remove(st)
                count+=2
 
        if not HashSet:
            return count
        else:
            return count+1