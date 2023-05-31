# Time complexity : O(n)
# Space complexity : O(1), since max size of the hashset is 52 (lower and upper case characters)
# The code tan on Leetcode

# Maintain a hash set, append elements that are not present in the set. If element is present in the set, remove it and increment count by 2 since the element can be a part of the palindrome. If elements are present in the hashset, increment count by 1 since it can be used as middle element of the palindrome

# class Solution:
#     def longestPalindrome(self, s: str) -> int:
#         cnt = 0
#         hash_set = set()
#         for i in range(len(s)):
#             if s[i] in hash_set:
#                 hash_set.remove(s[i])
#                 cnt+=2
#             else:
#                 hash_set.add(s[i])
        
#         if hash_set:
#             cnt+=1
#         return cnt

# Maintain a hash set with letters as keys. Append new elements to the set and remove already existing element. Increment counter by 2 when removing an element since it can be used to increase palindrome length by 2. At teh end, if the hash set is not empty, increment count by one since one element can be added at the center of the palindrome.
class Solution:
    def longestPalindrome(self, s: str) -> int:
        hash_set = set()
        count = 0
        for i in range(len(s)):
            if s[i] not in hash_set:
                hash_set.add(s[i])
            else:
                hash_set.remove(s[i])
                count+=2
        if hash_set:
            count+=1
        return count