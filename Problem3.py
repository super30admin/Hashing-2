# Time Complexity : O(n) where n is the number of letters in the input
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We add the element to the hashset if found and then when we find another one
# of the same character, we increase the final result by 2 since these
# elements can increase the final palindrome size by 2. We also account
# for odd sized palindrome by checking for single character occurences.


def longestPalindrome(self, s: str) -> int:
    res = 0
    found = set()
    
    for ch in s:
        if ch in found:
            found.remove(ch)
            res += 2
        else:
            found.add(ch)
    if len(found) > 0:
        return res + 1
    return res