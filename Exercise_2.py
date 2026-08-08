# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I had to remember that zero should reduce the balance and one should increase it.
# Approach: I converted the equal zero-and-one requirement into finding repeated prefix balances.
# Whenever the same balance appears twice, the subarray between those indexes has equal zeros and ones.
# I kept only the first index for each balance so the distance becomes as large as possible.


class Solution:

    def findMaxLength(self, nums):
        first_index = {0: -1}
        balance = 0
        longest = 0

        for index, num in enumerate(nums):
            if num == 0:
                balance -= 1
            else:
                balance += 1

            if balance in first_index:
                longest = max(longest, index - first_index[balance])
            else:
                first_index[balance] = index

        return longest
