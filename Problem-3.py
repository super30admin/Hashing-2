# T.c-> O(n)
# S.c-> O(1)
class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        if not s or len(s)==0:
            return 0
        
        hashmap= {}
        total= 0
        odd= False
        for i in s:
            # Already present.
            if i in hashmap.keys():
                hashmap[i]+=1
            # First entry.
            else:
                hashmap[i]=1
        
        for i in hashmap.keys():
            # If even.
            if hashmap[i]%2==0:
                total= total+ 2*hashmap[i]//2
            # If odd but greater than 2.
            elif hashmap[i]>2:
                total= total+ 2*(hashmap[i]-1)//2
                odd= True
            # If 1.
            else:
                odd= True
        # Check for odd no.of occurences.
        if odd:
            total+=1
        #print(hashmap)
        return total
