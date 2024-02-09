# Time Complexity = O(n)
# Space Complexity = O(1)


class Solution:
    def longestPalindrome(self, s: str) -> int:
        if len(s) == 0 or s == None:
            return 0
    
        palSet = set()      # For avoiding duplicate values, using set()
        length = 0
    
        for i in range(len(s)):
            char = s[i]

            # If char is is not in set, add it
            if char not in palSet:
                palSet.add(char)
            # If char is already present, increment the length by 2, and remove the already present char from set
            else:
                length += 2
                palSet.remove(char)
        
        # If set is empty, or len(set) == 0, it means that even number of characters were matched perfectly. Return length
        if not palSet:
            return length
        # If set isn't empty, that means atleast one unmatched character would be there. so max length becomes length + 1
        else:
            return length + 1
    
        
