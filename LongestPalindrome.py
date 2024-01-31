# Time Complexity = o(n) As there is only one for loop
# Space Complexity = o(1) Constant space complexity

class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = 0
        hashSet = set()

        for i in s:
            if i not in hashSet:
                hashSet.add(i)
            else:
                count += 2
                hashSet.remove(i)
        if len(hashSet) != 0:
            count += 1
        return count
