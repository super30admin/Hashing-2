# https://leetcode.com/problems/longest-palindrome
# Time complexity: O(n)
# Space complexity: O(n)
class Solution:
    def longestPalindrome(self, s: str) -> int:
        freq = {}
        count = 0
        odd_found = False
        # Counting frequency of each character and storing in a hashmap
        for i in s:
            freq[i] = freq.get(i,0) + 1
        # For each character, if its frequency is even, we can use all of them and if it's odd, we are using the maximum even count and one odd character if available
        for j in freq.values():
            if j%2==0:
                count+= j
            else:
                count+= j-1
                odd_found = True
        return count+1 if odd_found else count

        
        