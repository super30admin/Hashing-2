class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        #this map keeps track of the frequency of letters
        seen = {}
        for char in s:
            if char not in seen:
                seen[char]=1
            else:
                seen[char]+=1
        #this is the final result variable that will return length of palindrome
        result=0
        odd=0 #keeps track of instances of odd values

        #if the map has one letter, return the length of str
        if len(seen)==1:
            return(seen[s[0]])

        #check if the count of chars is even, if it is even in add the count to result
        #if its odd then add count of char - 1 to result
        for i in seen.values():
            if i>1:
                if i%2==0:
                    result+=i
                else:
                    result+=i-1
                    odd+=1
            else:
                odd+=1
        if odd > 0:
            result+=1

        return result
