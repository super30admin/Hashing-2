# https://leetcode.com/problems/subarray-sum-equals-k/

# Brutforce Time- O(n2) Space- O(1)Not defining any space

# class Solution:
#     def subarraySum(self, nums: list[int], k: int) -> int:
#         #  it checks the number of ways
#         counter = 0
#         # Iterate
#         for i in range(len(nums)):
#             # Each subarray sum should start fresh
#             sum = i
#             # iterate from the i
#             for j in range(i+1,len(nums)):
#                 #  take the previous and add the next
#                 sum = sum + nums[j]
#                 #  if the addition is equal to the target
#                 if sum == k:
#                     #  increase the number of ways
#                     counter +=1
#         #  return the final answer
#         return counter

# solution = Solution()
# print(solution.subarraySum([1,1,1],3))
# print(solution.subarraySum([1,2,3],3))


#  Hashmap Time- O(n) Space- O(n)
#  here we are checking the difference between the running sum minus target in the map if that's present then we got the one to reach to our target. so increase the counter it it's not present then keep the counter as it is. if that running sum is present in the map then increase the frequency by one else if we are adding for the first time then add one
class Solution:
    def subarraySum(self, nums: list[int], k: int) -> int:
        counter = 0
        running_sum = 0
        # in map we have running sum : Count(how many times the running sum has been seen)
        map = { 0 : 1 }

        for num in nums:    
            # find the running sum
            running_sum += num
            # find the differnce between that running sum and target
            diff = running_sum - k

            # update the counter with one if diff is present in the map means
            if diff in map:
                counter += map[diff]
            # other wise keep counter as it is
            else:
                counter = counter

            # update the running some map If we have seen this running sum before increase count
            if running_sum in map:
                map[running_sum] += 1
            # else if adding the running some for the first time
            else:
                map[running_sum] = 1
            # map[running_sum] = 1 + map.get(running_sum, 0)
            
        return counter


    
solution = Solution()
print(solution.subarraySum([1,2,3], 9))
# print(solution.subarraySum([1,2,3],3))