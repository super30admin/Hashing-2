# Time Complexity : O(N) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using a hashset to store the characters of the string. 
# I will iterate through the string and check if the character is already in the hashset. I will remove the same character and then 
# increase the count by 2. If the character is not in the hashset then I will add it to the hashset.
# In the last step if will increase the count by one as an element in the middle can be unpaired.
class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashset = set()
        count = 0
        for i in range(len(s)):
            if s[i] in hashset:
                count += 2
                hashset.remove(s[i])
            else:
                hashset.add(s[i])
        if hashset:
            count += 1
        return count
                


        