"""
Time Complexity: O(N) where n are tehe number of characters of the string
Space Complexity: O(26) ~ O(1) as there would be constant entries into the hashset

Explanation: Whenever we encounter the same character again in the string, we can use them to form pairs in palindrome, hence i'm tracking using set and adding 2. To handle odd palidrome, if the set is not empyt i add 1 to the answer. 
"""
class Solution:
    def longestPalindrome(self, s: str) -> int:
        hash_set = set()
        count = 0
        for ch in s: 
            if ch not in hash_set: 
                hash_set.add(ch)
            else: 
                hash_set.remove(ch)
                count+=2
                
        return count + 1 if hash_set else count
