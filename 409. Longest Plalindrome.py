# // Time Complexity : O(N)
# // Space Complexity : O(1). Even if the input size could be anything; the number of character are constant only.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = 0
        myset = set() # Implementing a set so that its easy to use functions like add and remove
        for i in s:
            if i in myset: #If there is a char already, remove it and increase the count by 2
                myset.remove(i)
                count+=2
            else:
                myset.add(i)
        if len(myset)!= 0:
            count+=1
        return count