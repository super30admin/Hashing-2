#Time Complexity:O(N)
#Space Complexity:O(K), where k is the number of unique characters in the string. 

class Solution:
    def longestPalindrome(self, s: str) -> int:
        if len(s)==None or len(s)==0:
            return len(s)

        count=0
        Set=set()
        for i in range(len(s)):
            if s[i] in Set:
                count +=2
                Set.remove(s[i])
            else:
                Set.add(s[i])
        if len(Set)!=0:
            count +=1
        return count
        