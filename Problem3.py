'''
Time Complexity: O(N)
Space Complexity: O(N) 

Approach: 
We iterate through the string and keep a count of the frequency of each character in the string.
For every even frequency we add the frequency to the maxLength variable.
For every odd frequency we add the frequency-1 to the maxLength variable, indicating that we take the max even number of the available odd length 
If the largestOdd variable is greater than 0 we add 1 to the maxLength variable, indicating that we can form an odd length palindrome

'''

class Solution:
    def longestPalindrome(self, s: str) -> int:
        maxLength = 0
        largestOdd = 0

        freq_map = defaultdict(int)

        for char in s:
            freq_map[char] += 1

        for key in freq_map:
            if freq_map[key] % 2 == 0:
                maxLength += freq_map[key]
            else:
                largestOdd+=1
                if freq_map[key] > 2:
                    maxLength += freq_map[key] - 1
                

        if largestOdd > 0:
            maxLength += 1

        return maxLength
