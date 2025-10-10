from collections import defaultdict


class Solution:
    def longestPalindrome(self, s: str) -> int:
        final = defaultdict()
        print(final)

        count = 0
        for i in s:
            if i not in final:
                final[i] = 1
            else:
                del final[i]
                count += 2
        if len(final) > 0:
            count += 1
        return count


