# Time complexity is O(n)
# Space complexity is O(n)
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        sum = 0
        mapping = defaultdict(list)
        maximum = 0

        #if balanced array starts at index 0, we can get accurate length of subarray
        mapping[0].append(-1)

        for i in range(len(nums)):
    
            # taking running sum of all elements and adding to map using sum as key and index as value to see at what indices we had the same count
            if nums[i] == 1:
                sum += 1
            else:
                sum -= 1
            mapping[sum].append(i)
        
        for i in mapping:
            #finding max length of continuous subarray by subtracting highest index of each mapping from its lowest index
            maximum = max(maximum, mapping[i][-1] - mapping[i][0])
            
        return maximum
