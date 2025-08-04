class Solution:
    def longestPalindrome(self, s: str) -> int:
        # Time Complexity: O(n), where n is the length of the input string s
        # Space Complexity: O(1), because the character set is limited (e.g. ASCII)

        # Count the frequency of each character in the string
        frequency = Counter(s)

        count = 0      # Tracks the length of the longest palindrome
        flag = False   # Tracks if there's at least one odd frequency

        # Iterate through each character and its frequency
        for char, value in frequency.items():
            if value % 2 == 0:
                # If frequency is even, use all occurrences
                count += value
            else:
                # If frequency is odd, use the largest even part and reserve 1 for center
                count += (value // 2) * 2
                flag = True

        # If there was any odd character count, we can place one in the middle
        if flag:
            count += 1

        return count
