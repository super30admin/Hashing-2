#tc = O(n)
#sc = O(1)
#successfully run on leetcode: Yes

class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashmap = {}
        ans = 0
        for letter in s:
            if letter not in hashmap:
                hashmap[letter] = 1
            else:
                hashmap[letter] += 1
                if hashmap[letter] == 2:
                    ans += 2
                    del hashmap[letter]
    #check is the hashmap is empty, if not, add 1 to ans
        if hashmap:
            ans += 1  
        return ans