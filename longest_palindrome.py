# TC : O(n)
# SC : O(n)

# Approach - using a set to keep track of characters. If character is repeated that means
# that char can be used in palindrome. So increment the count by 2 else add the char to set


class Solution:
    def longestPalindrome(self, s: str) -> int:
        hash_set = set()
        count = 0
        for char in s:
            if char in hash_set:
                count +=2
                hash_set.remove(char)
            else:
                hash_set.add(char)
        
        if len(hash_set) > 0:
            count+=1

        return count