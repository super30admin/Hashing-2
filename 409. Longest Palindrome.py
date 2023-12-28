# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n)
# Space Complexity : O(1) | max 26 alphabet letters
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# for double pass using hashmap
class Solution:
    '''
    - Will store the occurence of each alphabet in a hashmap
    - at the end even pair of each occurence will be counted (can be imagined to make palindrome pair)
    - and any one of the odd count be added (which will sit at the centre during palindrome formation)
    '''
    def longestPalindrome(self, s: str) -> int:
        hashmap = {}
        flag = False
        length = 0
        for char in s:
            hashmap[char] = hashmap.get(char, 0) + 1
        for key in hashmap:
            if hashmap[key] % 2 == 0:
                length += hashmap[key]
            else:
                if flag == False:
                    length += hashmap[key]
                    flag = True
                else:
                    length = length + (hashmap[key] - 1)
        return length
    

### for single pass using hashset
class Solution:
    '''
    - same concept as above one to form a palindrome
    - instead of hashmap, hashset will be used. first occurence of any alphabet will add value
    - second occurence will remove from hashset and increase the count. one odd value will be added at end(if exists)
    '''
    def longestPalindrome(self, s: str) -> int:
        hashset = set()
        count = 0
        for char in s:
            if char in hashset:
                count += 2
                hashset.remove(char)
            else:
                hashset.add(char)
        if len(hashset) != 0:
            count += 1
        return count