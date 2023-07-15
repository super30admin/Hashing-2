# Time: O(n^2)
# space: O(n)
#did the cod run? yes
#issues faced: coming up with idea of using cumsum
# Approach:
#using hashmap to store indices with same cumSum 
#this optimises brute force by saving time of computing the sum of subarray again and again. using this property: sum(i,j) = sum(0,j)-sum(0,i)


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hashmap = collections.defaultdict(deque) #O(n) space
        cumSum, result = 0, 0
        for i in range(len(nums)): #O(n)
            cumSum += nums[i]
            hashmap[cumSum].append(i)
            if cumSum == k:
                result += 1
        cumSum = 0
        for i in range(len(nums)): #O(n^2), when [1,0,0,0,0,0], k=0
            cumSum += nums[i]
            if hashmap.get(cumSum+k):
                while hashmap[cumSum+k] and hashmap[cumSum+k][0] <= i: hashmap[cumSum+k].popleft()
                result += len(hashmap[cumSum+k])
        return result