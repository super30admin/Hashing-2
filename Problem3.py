# Time Complexity :  O(n) where n is the length of the string s.
# Space Complexity :  O(1) as the hashmap size is bounded by the charset size, which is constant.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use a hashmap to track characters. Add 2 to count when a pair is formed, and add 1 more if any character is left.
def longestPalindrome(self, s: str) -> int:
    setA = set([])
    hm = {}
    count = 0

    for i in range(len(s)):
        if s[i] in hm:
            del hm[s[i]]
            count += 2
        else:
            hm[s[i]] = 1

    if hm.values():
        count += 1
    return count
