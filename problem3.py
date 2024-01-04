#time complexity : O(N), where N is the length of the string
#space complexity:O(N) because we used a map

class Solution:
    def longestPalindrome(self, s: str) -> int:
        char_frequency = {}

        for char in s:
            if char not in char_frequency:
                char_frequency[char] = 1
            else:
                char_frequency[char] += 1

        result = 0
        odd_char = 0

        for frequency in char_frequency.values():
            if frequency % 2 == 0:
                result += frequency
            else:
                result += frequency - 1
                odd_char = 1  # Set odd_char to 1 to indicate that there is at least one character with odd frequency

        return result + odd_char

sol = Solution()
s = "abccccdd"
result = sol.longestPalindrome(s)
print("The length of the longest palindrome is:", result)