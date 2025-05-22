#Hasmap/Hashset
#TC: O(n)
#SC: O(1)

# A set is used to track unpaired characters while iterating through the string.
# Each time a character already in the set is encountered, it forms a pair and is removed from the set, adding 2 to the palindrome length since the pair can be symmetrically placed.
# After processing all characters, if the set is not empty, one unpaired character can be placed in the center. In that case, 1 is added to the final count to account for the central character.

class Solution:
    def longestPalindrome(self, s: str) -> int:
        # A set to track characters that have not yet formed a pair
        char_set = set()
        
        # Variable to count the length of palindrome formed so far
        count = 0

        # Iterate through each character in the string
        for c in s:
            if c in char_set:
                # If character already seen once, we found a pair
                char_set.remove(c)
                count += 2  # Add 2 to the palindrome length
            else:
                # If it's the first time we've seen this character, add it to the set
                char_set.add(c)

        # If there are any characters left in the set,
        # one of them can be placed in the middle of the palindrome
        if char_set:
            count += 1

        return count


#Approach-2: same but using dict/hashmap
#TC: O(n)
#SC: O(1)
# def LongestPalindrome(self, str1):
#         # Dictionary to store the count of each character in the input string
#         char_dict = dict()

#         # Count the frequency of each character
#         for i in str1:
#             if i not in char_dict:
#                 char_dict[i] = 0
#             char_dict[i] += 1

#         # Extract all frequency values from the dictionary
#         all_values = list(char_dict.values())

#         one_character = 0  # Flag to check if there's at least one character with an odd frequency
#         max_length = 0     # Length of the longest possible palindrome

#         # Loop through each character frequency
#         for i in all_values:
#             if i % 2 == 0:
#                 # If the frequency is even, use all of it in the palindrome
#                 max_length += i
#             else:
#                 # If the frequency is odd, use (i - 1) to keep it even for symmetry
#                 max_length += (i - 1)
#                 # Set the flag since we can place one odd character in the middle
#                 one_character = 1

#         # Add 1 if there's at least one odd-count character to place in the center
#         return max_length + one_character