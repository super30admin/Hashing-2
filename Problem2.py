class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hash_map=dict()
        hash_map[0]=-1
        length_of_array=len(nums)
        sum=0
        length=0
        for i in range(length_of_array):
            if(nums[i]==0):
             sum+=-1
            else:
             sum+=1   
            print(sum)
            if( sum in hash_map):
                length=max(length,i - hash_map[sum])
            else:
                hash_map[sum]=i
        return length
                