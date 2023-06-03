#Time Complexity : O(n)
#Space Complexity : O(n)
#Code ran successfully on the leetcode
#Faced no problems while developing the code

#Program to find the length of the longest palindrome
#We are going to implement this program using Hashset
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        #Creating an empty hashset and length
        self.HashSet=[]
        self.length=0
        #If the length is equal to 1, we will return 1
        if(len(s)==1):
            return 1
        for i in range(0,len(s)):
            #If the s[i] is already present in the hashset, we will remove that and add 2 to the lentg variable
            if(s[i] in self.HashSet):
                self.HashSet.remove(s[i])
                self.length+=2
            #If the value is not present in the HashSet, we will append that to the HashSet
            else:
                self.HashSet.append(s[i])
        #If there is any data left in the HashSet, we will add 1 to the length
        if(len(self.HashSet)>=1):
            self.length+=1
        #Finally we are returning length 
        return self.length