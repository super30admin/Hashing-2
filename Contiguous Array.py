# Time complexity : O(n)
# Space complexity : O(n), since all values of running sum will be stored in the hash map
# Maintain a hashmap with key being running sum at every index and value being its index, since we want to compute length of the sub array. Increment the sum by 1 if nums[i] = 1 and decrement sum by 1 if nums[i] = 0
#At every index, check if the current running sum is already present in the hash map. If it is present, check the corresponding length

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        
        hash_map = {0: -1}

        rSum = 0; mlen = 0

        for i in range(len(nums)):
            if nums[i] == 0: rSum -= 1
            else:
                rSum +=1
            
            if rSum in hash_map:
                mlen = max(mlen, i - hash_map[rSum])
            else:
                hash_map[rSum] = i
        return mlen