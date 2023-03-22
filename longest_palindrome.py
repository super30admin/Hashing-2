# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""The solution is to use a hashmap to store the frequency of each character in the string. 
Then, we iterate through the hashmap and add the floor of the frequency of each character 
divided by 2 to the answer. This is because we can use the floor of the frequency of each 
character divided by 2 to form a palindrome. Then, we multiply the answer by 2 to account 
for the fact that we can use the same character to form a palindrome. Then, we check if the 
frequency of any character is odd. If it is, we add 1 to the answer to account for the fact 
that we can use one character to form a palindrome."""

import collections

class Solution:
    def longestPalindrome(self, s: str) -> int:
        #Solution 1:
        # hashmap = collections.Counter(s)

        # answer = sum([x // 2 for x in list(hashmap.values())]) * 2

        # if sum([x%2 for x in list(hashmap.values())]) > 0:
        #     answer += 1
        #     return answer
        # else:
        #     return answer


        #Solution 2:
        hashmap = collections.defaultdict(int)

        odds = 0

        for i in range(len(s)):
            hashmap[s[i]] += 1
            if hashmap[s[i]] % 2 == 1:
                odds += 1
            else:
                odds -= 1

        answer = sum([x // 2 for x in list(hashmap.values())]) * 2
        
        return answer + 1 if odds > 0 else answer