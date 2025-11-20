"""
We have to traverse the whole string and keep track of the characters and its frequency, so its a O(N) TC and since we dont use any extra space except for the hashset, its O(1) SC
We have O(1) space complexity (hashset can have atmost 26 elements of lower case, and 26 of higher case)"""

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        hset = set() #create a hashset to store the characters
        count = 0 #set count to 0
        for ch in s: #for each character in s
            if ch in hset: #if it is already present in the hashet
                count += 2 #increment its count by two (pair found)
                hset.remove(ch) #remove the character from set
            else:
                hset.add(ch) #if not, add it to the set
        if len(hset) > 0:
            return count + 1 #if there are any characters left in the set, we can place one in the center, hence  +1 to the count
        return count

