class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # Time complexity - o(n)
        # Space complexity - o(n)
        hashTb = {0:1}
        count = 0
        r_sum = 0

        for i in range(len(nums)):
            r_sum+=nums[i]
            if r_sum-k in hashTb:
                    count+=hashTb[r_sum-k]
            if r_sum in hashTb:
                hashTb[r_sum]+=1
            else:
                hashTb[r_sum] = 1
            

        return count

           