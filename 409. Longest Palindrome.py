"""
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Example 3:

Input: s = "bb"
Output: 2
"""
class Solution:
def longestPalindrome(self, s: str) -> int:
    """
If we found new charecter for first time insert it into dictionary.
If we found charecter for the second time delete the charecter from dictionary and increment the count by 2.
Atlast only the charecters appeared for first time remains in the dictionary. If the length of the dictionary meaning there are some charecters that are of length 1.
Then we will add only one to the total count and return count.
"""

    # Time Complexity : O(N) => O(N) for looping through string, O(1) for finding length of dictionary
    # Space Complexity : O(1) because eventhough we use Hashmap the max length of hashmap is 26.
    dic = dict()
    count = 0
    for i in range(len(s)):
        if s[i] not in dic:
            dic[s[i]] = 1
        else:
            count += 2
            dic.pop(s[i])

    if len(dic) > 0:
        count += 1
    return count
