class Solution:
    # Time Complexity: O(n)
    def longestPalindrome(self, s: str) -> int:
        map_p = {}
        count = 0

        for i in range(len(s)):
            if s[i] in map_p:
                count += 2
                del map_p[s[i]]
            else:
                map_p[s[i]] = 1
        print(map_p)
        if len(map_p) != 0:
            count += 1
        return count
