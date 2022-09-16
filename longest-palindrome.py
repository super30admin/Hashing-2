# Time Complexity: O(n)
# Space complexity: O(n)

# The program successfully ran on Leetcode

class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashmap = {}
        
        for char in s:
            if char not in hashmap:
                hashmap[char] = 1
            
            else:
                hashmap[char] += 1
        count = 0
        odd = 0
        
        for val in hashmap.values():
            if val % 2 == 0:
                count += val
            else:
                odd += 1
                count += val
        
        return count if odd <= 1 else count - odd + 1




'''
class Solution:
    def longestPalindrome(self, s: str) -> int:
        if len(s) == 0 or s == None:
            return 0
        
        oddchars = set()
        l = 0
        
        for i in s:
            if i in oddchars:
                l += 2
                oddchars.remove(i)
                
            else:
                oddchars.add(i)
        
        if len(oddchars) > 0:
            l += 1
        
        return l
'''

# The first program is implemented using Hashmap and the second one is implemented usng hashset

