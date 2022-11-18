class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:

        mp = {}
        rsum = 0
        mp[0] = 1
        count = 0

        #base case
        if len(nums) == 0:
            return 0

        for i in range(len(nums)):
            rsum = rsum + nums[i]    
            # print(rsum, nums[i])
            # print(mp)
            if rsum - k in mp:
                count = count + mp[rsum-k]
            # get save us from key error , if key not fount it gives zero   
            mp[rsum] = mp.get(rsum, 0) + 1     
            
            
        return count
#Time complexity O(n)
#Space Complexity O(n)
    
