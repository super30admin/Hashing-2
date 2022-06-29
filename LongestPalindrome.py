class Solution:
    def longestPalindrome(self, s: str) -> int:
        list = set()
        count = 0
        for i in s:
            if(i in list):
                count = count + 2
                list.remove(i)
            else:
                list.add(i)
        if(len(list) != 0):
            return count+1
        else:
            return count
                
        