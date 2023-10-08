# t - o(n), s - o(n)
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hashmap = {0:-1}

        run = 0
        max_length = 0

        for i in range(0,len(nums)):
            if nums[i] == 0:
               run -= 1
            elif nums[i] == 1:
                run += 1

            if run not in hashmap:
                hashmap[run] = i

            else:
                max_length = max(max_length,i - hashmap[run])
        return max_length
