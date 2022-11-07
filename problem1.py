#time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: yes
#If we have a running sum and for 2 indexs i,j such that j>i, then sum from i to j can be written
# as running_sum[j]-running_sum[i-1]. Loop through the input and calculate running sum. If sum-k 
#is in hashmap, then this means we have discoverd some subarrays whose sum equals k. Increment
#the count by the value given by the key of sum-k. If sum in new in hashmap, then insert it with
#value 1. IF it is not a new key, then increment the value already present.

class Solution:
    def subarraySum(self, nums, k) -> int:
        
        total_sum=0
        running_sum={total_sum:1}
        count=0
        for i in nums:
            total_sum+=i
            if(total_sum-k in running_sum):
                count+=running_sum[total_sum-k]
            if(total_sum in running_sum):
                running_sum[total_sum]+=1
            else:
                running_sum[total_sum]=1
        return count
s=Solution()
nums=[1,2,3]
k = 3
print(s.subarraySum(nums,k))
