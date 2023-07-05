# Time Complexity : O(n)
# Space Complexity : O(n)
# I have used running sum approach. Checked if difference of the sum and k is present in the hash map. 
# If present, increment the count to number of occurence of the value.
# Running sum is added to the hash map. Here, count of the sum is stored in the hash map

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count_hash={}
        count_hash[0]=1 #To identify the initial subarray
        count=0
        running_sum=0
        for i in nums:
            running_sum += i
            diff=running_sum-k
            if diff in count_hash:
                count += count_hash[diff]
            if running_sum in count_hash:
                count_hash[running_sum]= count_hash[running_sum]+1        
            else:
                count_hash[running_sum]=1
                    
        return count
            