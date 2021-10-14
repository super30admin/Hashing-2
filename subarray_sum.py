
""""
Time Complexity: O(n)
Space Complexity: O(n)
Did your code run on leetcode? : yes
Issues faced:

"""
class Solution:
    def subarraySum(self, nums, k) -> int:
        cs = 0
        c = 0
        hp = dict({0 : 1})
        for x in range(len(nums)):
            cs += nums[x]
            print("cs=",cs)
            diff = cs - k
            if diff in hp:
                c = c + hp[diff]
            if cs in hp:
                    hp[cs] += 1
            else:
                hp[cs] = 1
        return c
if __name__ == '__main__':
    S = Solution()
    print(S.subarraySum([1,1,1], 2))
