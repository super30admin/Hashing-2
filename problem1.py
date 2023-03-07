#time complexity is O(N)
# space complexity is O(N)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        cumulative_sum=[0]
        dict1={}
        count=0
        for x in nums:
            cumulative_sum.append(cumulative_sum[-1]+x)
        dict1={0:1}
        for x in range(1,len(cumulative_sum)):
            diff_from_k=cumulative_sum[x]-k
            if diff_from_k in dict1:
                count=count+dict1[diff_from_k]
            if cumulative_sum[x] in dict1:
                dict1[cumulative_sum[x]]=dict1[cumulative_sum[x]]+1
            else:
                dict1[cumulative_sum[x]]=1
        return count