from collections import Counter


class Solution:
    def subarraySum(self, A, K):
        count = Counter()
        count[0] = 1
        ans = su = 0
        for x in A:
            su += x
            ans += count[su - K]
            count[su] += 1
        return ans


if __name__ == '__main__':
    h = Solution()
    result = h.subarraySum([28, 54, 7, -70, 22, 65, -6], 100)
    print(result)
