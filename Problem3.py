"""
TC: O(N) {we iterate twice, one for the hashmap creation and the other for calculating the res}
SC: O(1) {since we know there are only 26 lowercase and 26 uppercase characters, hence its constant}

Approach:

Intuition is that the palindrome consists of Even frequencies of characters and only one odd frequency of character in the middle.

We first create our counter hashmap which stores the frequency of each character in c1. We then iterate over the frequencies
and if its even, we simply add that to our res and if its odd, we add the freq-1 (since its even) and update our odd var, this
variable will tell us if we encounter more than 0 odd frequencies, in the end we return the sum of res and odd (since the palindrome
can contain one odd freq.)

This problem successfully ran on Leetcode.
"""

class Solution:
    def longestPalindrome(self, s: str) -> int:
        odd = 0
        res = 0
        c1 = Counter(s)

        for v in c1.values():
            if v%2 == 0:
                res += v
            else:
                if v>1:
                    res += v-1
                odd = 1
        return res+odd
                
        
        

        
