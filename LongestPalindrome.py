class LongestPalindrome(object):
    '''
    Solution:
    1. Create a set and add chars from string if not found.
    2. If already present, remove the char and add 2 to maximum possible palindrome length
    3. If set is not empty after traversal, add 1 to the previous length and return the length
    '''

    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        # O(n) Time Complexity | O(1) Space Complexity
        maxLength = 0
        frequencySet = set()

        for char in s:
            if char in frequencySet:
                frequencySet.remove(char)
                maxLength += 2
            else:
                frequencySet.add(char)

        if len(frequencySet) != 0:
            return maxLength + 1

        return maxLength