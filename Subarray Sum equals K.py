#Time Complexity :O(n) # We will iterate through all nums
#Space Complexity :O(n) #we will use hashmap
#Did this code successfully run on Leetcode : Yes

#Intution
#we will calucalate rSum and also store {rsum: freq} pair to check if we find rsum-k already in hashmap
#which will tell us freq no of sub arrrays can be formed and caluclate count
#when we found same rsum we will increase the freq

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        n=len(nums)
        rsum=[0]*n  #TO TRACK RSUM
        rsum[0]=nums[0]
        count=0
        hashMap={0:1}   #{rsum: freq} Add dummy so not to miss starting pair


        for i in range(1,n):    #FILL rsum
            rsum[i]=rsum[i-1]+nums[i]

        #check for (rsum-k) in Map
        for i in range(n):
            if rsum[i]-k in hashMap:
                count+=hashMap[rsum[i]-k]  #add the frequency not '1' to find all possible subarrays backwards
            hashMap[rsum[i]] = hashMap.get(rsum[i], 0) + 1       #create a rSum entry to find in future  in hashMap

        return count
