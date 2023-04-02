# T.c-> O(n)
# S.c-> O(1)
class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        if not s or len(s)==0:
            return 0
        
        hashset= set()
        total=0
        for i in range (len(s)):
            # If letter already present in hashset
            if s[i] in hashset:
                # Increment total and remove element.
                total+=2
                hashset.remove(s[i])
            else:
                # Else append element.
                hashset.add(s[i])
        
        # Check for odd number of occurences.
        if len(hashset)!=0:
            total+=1
        return total
