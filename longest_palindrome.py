"""
# Time: O(n) — single pass through the string.
# Space: O(k) - hence O(1) — where k is the number of unique characters (at most 52 for alphabets).
# Did this code successfully run on Leetcode : Yes.
# Any problem you faced while coding this : No
"""

class Solution:
    def longestPalindrome(self, s: str) -> int:
        store = set() #initialize a set
        result_cnt = 0 #initialize a counter

        for i in s: #iterate through the string
            if i in store: #check if the character is in the set
                result_cnt+=2 #if the same character is already in the set that means its a pair and we can increase the counter to 2 [as two characters make a pair and remove the existing character from the set as we are using it]
                store.remove(i)
            else:
                store.add(i) #if that character is not present then add it.

        if store: #after we go through each and every character in the string and any character still remains that means they are the single ones and we can only add one of them.
            result_cnt+=1  #add only one to the middle of that palindrome.
        return result_cnt