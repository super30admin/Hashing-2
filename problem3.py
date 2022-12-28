# Longest Palindrome

# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // code here along with comments explaining approach


def longestPalindrome(self, s: str) -> int:
    hashset = set() # O(1)
    count = 0
    for i in s: # O(n)
        if i in hashset:
            count = count+ 2
            hashset.remove(i)
        else:
            hashset.add(i)
    if hashset:
        count = count + 1
    return count