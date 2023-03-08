# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def longestPalindrome(self, s: str) -> int:
        dic = collections.defaultdict(int)
        longest = 0
        flag = False
        for i in range(len(s)):
            dic[s[i]] += 1
        for val in dic.values():
            if val % 2 == 0:
                longest += val
            else:
                if val > 1:
                    longest += val-1
                flag = True
        # print(dic)
        if flag:
            return longest + 1
        return longest