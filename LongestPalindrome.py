#I have implemented it using a hashmap.
#Hashmap is used to keep track of the occurance of each letter.
#If the count of a particular letter is 2, then count is updated and then it is removed from the hashmap. If at the end, the number of single letters that are present 
#is greater than 0, then the count is increased by 1.
#Time complexity: O(n) and space complexity is O(n)
class Solution:
    def longestPalindrome(self, s: str) -> int:
        #Using hashmap
        if s==None:
            return 0
        hashmap={}
        count=0
        for char in s:
            if hashmap.get(char)!=None:
                count=count+2
                del hashmap[char]
            else:
                hashmap[char]=1
        if len(hashmap)>0:
            count=count+1
            return count
        else:
            return count