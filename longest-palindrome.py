# Count the frequenscy of each characters and sum all the event count chanracters. The odd count 
# characters are taken as their count - 1 and summed. If any character is still left behind, add 1

# Time complexity : O(n)
# Space complexity: O(1)

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        d={}
        for i in s:
            if i not in d:
                d[i]=1
            else:
                d[i]=d[i]+1
        c=0
        flag=0
        print(d)
        for i in d.values():
            if i%2==0:
                c+=i
            else:
                c+=i-1
                flag=1
        if flag==1:
            c+=1
        return c
            

