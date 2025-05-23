from collections import Counter
"""
TC -> O(n) where n is length of string
SC -> O(m) where m is the number of distinct characters in string
Logic:
Count the frequencies of characters. Even number of characters can form a palindrome easily. 
So we use the entire count. When we have odd frequency characters, if we subtract 1 from it, the even 
frequencies can be used to form a palindrome. For eg: if frequency(c) = 3, 2 c's can be used to form a 
palindrome. Similarly from all the odd frequencies, we can use an even number of those to form a palindrome.
Finally if we have odd frequencies, we use a flag to denote that and finally we all that to the final output.
"""
class Solution:
    def longestPalindrome(self, s: str) -> int:
        hmap = Counter(s)
        longest_palindrome = 0
        is_odd = False
        for key in hmap:
            if hmap[key]%2==0:
                longest_palindrome = longest_palindrome+hmap[key]
            else:
                longest_palindrome+=hmap[key]-1
                is_odd = True
        return longest_palindrome+1 if is_odd else longest_palindrome