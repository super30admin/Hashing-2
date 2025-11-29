class Solution:
    def longestPalindrome(self, s: str) -> int:
        #using a map to store frequqncies
        freq_map={}
        result=0
        flag=False
        for c in s:
            freq_map[c]=freq_map.get(c,0)+1
        # if it is even take multiples of 2 
        # if it is odd only take one of total odd characters
        for v in freq_map.values():
            result+=(v//2) * 2
            if v%2==1:
                flag=True
        if flag==True:
            result+=1
        return result
       

        