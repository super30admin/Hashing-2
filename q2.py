from typing import List
#Time Complexity : O(n), where n is number of elements in nums
#Space Complexity : O(n), where n is number of elements in nums
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Not anything specific

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        #This is just default case, Where we checking the input
        if(len(nums)==0):
            return 0
        #Here we will use running sum paradigm, Where it values get incremented whenever it encounters 1, it value gets decremented whenever it encounters 0
        
        #This following hashmap contains the first occurance of the 0's and 1's, But we have intiated with a dummy variable at -1
        hashmap={0:-1}
        rsum=0
        #output contains the length of the subarray which has equal numbers of ones and zeros
        output=0
        for i in range(len(nums)):
            if(nums[i]==0):
                #This is when we encounter 0
                rsum=rsum-1
                if(rsum in hashmap):
                    length=i-hashmap[rsum]
                    if(length>output):
                        output=length
                else:
                    #This is the first occurance of the rsum, Therefore we have to put in the hashmap
                    hashmap[rsum]=i
            if(nums[i]==1):
                #This is when we encounter 1
                rsum=rsum+1
                if(rsum in hashmap):
                    length=i-hashmap[rsum]
                    if(length>output):
                        output=length
                else:
                    #This is the first occurance of the rsum, Therefore we have to put in the hashmap
                    hashmap[rsum]=i
        #print(hashmap)
        #print(output)
        return output
