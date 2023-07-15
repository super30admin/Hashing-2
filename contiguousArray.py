#Time: O(n)
#Space: O(n), when most of the elements are of same type
# did the code run? yes
#issues faced: missed the case where cumSum 0 is also a valid subarray
#Approach:
# find the cum sum util each index
# if same cumsum appears more than once, it means that there exists a valid subarray between those indices
# maintain min and max indices for each possible cumsum using a hashmap
# if cumsum is zero at an index then arr 0 to i is a valid subarray
# lengths of subarray can be computed these indices and the max is returned

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        n, cumSum = len(nums), 0
        hashmap = collections.defaultdict(lambda: [n, -1])
        for i in range(n):
            cumSum = cumSum+1 if nums[i] else cumSum-1
            lst = hashmap[cumSum]
            lst[0], lst[1] = min(lst[0], i), max(lst[1], i)
            hashmap[cumSum] = lst
        return max([hashmap[key][1]-hashmap[key][0] if key else hashmap[key][1]+1 for key in hashmap.keys()])
        
        
        