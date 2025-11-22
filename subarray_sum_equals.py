# https://leetcode.com/problems/subarray-sum-equals-k/

# To find the subarray sum we are using runnign sum approach with hashmap datastructure. It's checking the required difference (running sum - k) has happened before. If it is, means we got one way to reach to the target so increase the counter. At last it updates the map with the running sum for the future elements.
# Time Complexity- O(n) Space Complexity- O(n)
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
        return counter


    
solution = Solution()
print(solution.subarraySum([1,2,3], 9))
# print(solution.subarraySum([1,2,3],3))