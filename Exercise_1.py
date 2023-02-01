#Time Complexity : O(N), N being the total number letters in string.
#Space Complexity : O(1), because dictionary will have 26 keys and values at max.
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Forgot to add 2, rather than 1, to count 
# in the beginning.  

#Your code here along with comments explaining your approach in three sentences only
'''Create a dictionary where the count of the occurance of each character is kept. 
Then at the same time, if any character has more than or equal to 2 occurances, add
2 to the count. In the end, add 1 to count if there are any remaining values greater
than 1, for the middle value. 
'''
class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = 0
        dictionary = {}
        # keep track of characters and number of times occurred as well as count. 
        for c in s:
            if c not in dictionary.keys():
                dictionary[c]=1
            else:
                dictionary[c] = dictionary[c]+1
            if dictionary[c]>=2:
                count = count+2
                dictionary[c] = dictionary[c]-2
        # if there are any remaining values, increment count by 1. 
        if sum(dictionary.values())>0:
            count = count+1
        return count
