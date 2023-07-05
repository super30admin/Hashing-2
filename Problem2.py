# Time Complexity : O(n)
# Space Complexity : O(n)
# I have used running sum approach. Here if the same number occurs in hash map, then 1 and 0 is balanced. 
# Index of the element is fetched and length is calculated. Here, index is stored in the hash map.

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        frequency_hash={}
        max_length=0
        count=0
        for i in range (0, len(nums)):
            if nums[i] == 0:
                count = count - 1
                
            if nums[i] == 1:
                count = count + 1
            
            if count == 0:
                if i+1 > max_length:
                    max_length = i+1
            elif count in frequency_hash:
                length=i-frequency_hash[count]
                if length>max_length:
                    max_length=length
            else:
                frequency_hash[count]=i
        
        return max_length
            
                    
                    