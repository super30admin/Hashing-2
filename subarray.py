class Solution:
    def subarraySum(self,nums,k):
        count=0
        current_sum=0
        prefix_sums={0:1}

        for num in nums:
                current_sum +=num
                if(current_sum-k)in prefix_sums:
                    count+=prefix_sums[current_sum-k]
                prefix_sums[current_sum]=prefix_sums.get(current_sum,0)+1
        return count
sol=Solution()
print(sol.subarraySum([1,1,1,],2))
print(sol.subarraySum([1,2,3],3))