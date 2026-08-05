# https://leetcode.com/problems/longest-palindrome/

# Time complexity: O(n) 
# Space complexity: O(1)
# Explanation: Store the frequency of each char in a hashmap; in the same linear traversal check if the count is odd or evem - for each odd increment a counter, and for each even decrement the same counter
# Finally check if there is any odd count - if no simply return the len of s; otherwise we can substact all odd occurances except 1 which can be used in middle

class Solution:
    def longestPalindrome(self, s: str) -> int:
        freq = collections.defaultdict(int)
        odd_count = 0
        for ch in s:
            freq[ch] += 1
            if freq[ch] % 2 == 1:
                odd_count += 1
            else:
                odd_count -= 1

        if odd_count > 0:
            return len(s) - odd_count + 1
        else:
            return len(s)
