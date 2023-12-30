"""
a:1
b:3
c:4
d:2
ans = c(4) + d(2) + b(2) + a or b(1) = 9
1. Create a HashMap of no of occurrences for each char. 
2. If freq_val is even, like aa or aaaa then we can make a palindrome
3. If freq_val is odd, like b or bbb or bbbbb. We can make a palindrome with bbb by taking two b's or bbbb by taking 4 b's. - update the val with 1. 
4. If freq_map is left with a single c or a single b. Then we take only one of all of the single values to put in the center and make a palindrome. 
5. TC - O(N), SC - O(N)
"""

class Solution:
    def longestPalindrome(self, s: str) -> int:
        length_palindrome = 0
        freq_map = {}
        for c in s:
            freq_map[c] = freq_map.get(c, 0) + 1
        for key, val in freq_map.items():
            if val%2 == 0:
                length_palindrome += val
                freq_map[key] = 0
            elif val%2 == 1 and val>2:
                length_palindrome += val-1
                freq_map[key] = 1
        for key, val in freq_map.items():
            if val%2 == 1:
                length_palindrome += 1
                break
        return length_palindrome


    


        
        

        