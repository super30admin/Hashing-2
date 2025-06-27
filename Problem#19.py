'''
409. Longest Palindrome
'''

# Time Complexity : O(n) for iterating through the string and counting character frequencies using a hashmap where n is the length of the string.
# Space Complexity : O(1) (since we only use a fixed-size hashmap for 52 letters)
# Did this code successfully run on Leetcode : Yes, it passed all test cases.
# Any problem you faced while coding this : Yes, initially I thought about using a brute force approach to check all substrings, but it was inefficient for larger strings. I then realized that counting character frequencies would be a more optimal solution.

class Solution:
    def longestPalindrome(self, s: str) -> int:
        char_count = {} # humne ek dictionary banayi hai jisme character ki frequency store karenge (we created a dictionary to store the frequency of characters)
        for char in s: # hum string ke har character par iterate karte hain (we iterate through each character in the string)
            char_count[char] = char_count.get(char, 0) + 1 # humne character ki frequency ko update kiya hai (we updated the frequency of the character)
        length = 0 # humne length ko 0 se initialize kiya hai (we initialized length to 0)
        odd_found = False # humne odd_found ko False se initialize kiya hai (we initialized odd_found to False)
        for count in char_count.values(): # humne character count ki values par iterate kiya hai (we iterate through the values of character count)
            if count % 2 == 0: # agar count even hai to hum length ko update karte hain (if the count is even, we update the length)
                length += count # humne length ko count se update kiya hai (we updated the length with the count)
            else: # agar count odd hai to hum length ko update karte hain (if the count is odd, we update the length)
                length += count - 1 # humne length ko count - 1 se update kiya hai (we updated the length with count - 1)
                odd_found = True # humne odd_found ko True set kiya hai (we set odd_found to True)
        if odd_found: # agar koi odd count mila hai to hum length ko 1 se badhate hain (if we found any odd count, we increase the length by 1)
            length += 1 # humne length ko 1 se badhaya hai (we increased the length by 1)
        return length # hum length ko return karte hain (we return the length)


