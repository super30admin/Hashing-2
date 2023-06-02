class Solution:
    def longestPalindrome(self, s: str) -> int:
        hash_map=dict()
        count=0
        for i in s:
            if(i in hash_map):
              del hash_map[i]
              count+=2
            else:
                hash_map[i]=1
        if not not hash_map :
            count+=1
        return count
           