# Time Complexity : O(n) where n is the length of the input string
# Space Complexity : O(n) where n is the length of the input string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# The longest palindrome can be formed by using the even number of characters from the input string.
# We add up all the even number of characters from the input string to form the longest palindrome.
# If we find any odd number of characters, we add up all the even number of characters and add 1 to the count.

from collections import defaultdict
class Solution:
    def longestPalindrome(self, s: str) -> int:
        # Initialize a hashmap to store the count of characters
        map = defaultdict(int)
        count = 0
        # Initialize a flag to check if we have an odd number of characters
        flag = False
        for c in s:
            # Increment the count of characters in the hashmap
            map[c] += 1
        # Iterate through the hashmap to find the longest palindrome
        for i in map:
            # If the count of characters is even, add it to the count
            if map[i] % 2 == 0:
                count += map[i]
            # If the count of characters is odd, add the even number of characters to the count and set the flag to True
            else:
                count += map[i] - 1
                flag = True
        # If we have an odd number of characters, add 1 to the count and return the count
        return count + 1 if flag else count

# Time Complexity : O(n) where n is the length of the input string
# Space Complexity : O(n) where n is the length of the input string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# We can use a set to store the characters of the input string.
# If we find a character in the set, we remove it from the set and increment the count by 2.
# If we find a character which is not in the set, we add it to the set.
class Solution:
    def longestPalindrome(self, s: str) -> int:
        # Initialize a set to store the characters
        map = set()
        count = 0
        for c in s:
            # If the character is in the set, remove it and increment the count by 2
            if c in map:
                count += 2
                map.remove(c)
            # If the character is not in the set, add it to the set
            else:
                map.add(c)
        # If the length of the input string is equal to the count, it means that all the characters are even
        # If not, add 1 to the count and return the count
        if len(s) == count:
            return count
        else:
            return count + 1