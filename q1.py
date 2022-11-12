from typing import List
#Time Complexity :O(n), where n is the number of elements in nums
#Space Complexity :O(n), where n is the number of elements in nums 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Not anything specific

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        #This is just default case, Where we checking the input
        if(len(nums)==0):
            return 0
        
        #For this problem also, we are using running sum paradigm,
        #This following hashmap contains the count of  all the occurance of the rsum, But we have intiated with a dummy value rsum=0 at -1(Don't think about the negative index as in python)
        hashmap={0:1}
        rsum=0
            
        output=0
        for i in range(len(nums)):
            rsum=rsum+nums[i]
            
            find=rsum-k
            
            if(find in hashmap):
                output+=hashmap[find]
            
            #Here we have to update the elements in hashmap as per our needs
            if(rsum in hashmap):
                hashmap[rsum]+=1
            else:
                hashmap[rsum]=1
            
        #print(hashmap)
        #print(output)
        return output   
        
