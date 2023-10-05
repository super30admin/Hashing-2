#Did this code successfully run on Leetcode : yes, 409
# Any problem you faced while coding this : in hashset soltn, while removing i did count+=1 instead of 2
#In hashmap soltn, it took time to figure what happens to count when odd chars are present.

#TC: O(n), n is length of string
#SC: O(1), since max 26 chars
#using hashset
class Solution:
    def longestPalindrome(self, s: str) -> int:
        hset= []
        count = 0
        for i in range(len(s)):
            
            if s[i] not in hset:
                hset.append(s[i])
            else:
                count += 2
                hset.remove(s[i])
        if len(hset) > 0:
            count += 1
            
        return count

#using hashmap  
#TC: O(n), n is length of string
#SC: O(1), since max 26 chars
class Solution:
    def longestPalindrome(self, s: str) -> int:
        hmap= {}
        count = 0
        odd_char = 0
        for i in range(len(s)):
            if s[i] not in hmap:
                hmap[s[i]] = 1
            else:
                hmap[s[i]] += 1
        for key , value in hmap.items():
            if value%2==0:
                count += value
            else:
                count += value-1
                odd_char = 1
        return count + odd_char
                