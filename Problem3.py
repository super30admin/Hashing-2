# Time Complexity : O(n)
# Space Complexity : O(n)
# Iterating over each letter in the word, If the letter is not present in hash set, it is added. 
# If the letter already exists, count is increment to 2. That is, the letter can be added at the front and end.
# Finally all single letters are left out at the set. If set has values then any one value can be added at the middle.

class Solution:
    def longestPalindrome(self, s: str) -> int:
        hash_set=set()
        count=0
        for i in s:
            if i in hash_set:
                count+=2
                hash_set.remove(i)
            else:
                hash_set.add(i)
        
        if len(hash_set)>0:
            count+=1
        
        return count