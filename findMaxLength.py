 # Time complexity - o(n)
# Space complexity - o(n)

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        
        max_len = 0
        
        r_sum = 0
        hashTb = {0:-1}

        for i in range(len(nums)):
            if nums[i]==0:
                r_sum-=1
            else:
                r_sum+=1

            if r_sum in hashTb:
                max_len = max(max_len,i-hashTb[r_sum])
            else:
                hashTb[r_sum]=i


        return max_len

        