#TC: O(n), n is length of nums
#SC: O(n), n is unique Rsum, there can be n unique Rsums, think of [1,1,1,1,1,1...]
#Did this code successfully run on Leetcode : yes, 560
# Any problem you faced while coding this : yeah initilaly i put the index in my hmap, then i realised i dont neeed the length of subarray whose sum is k, it is when my test case for [0,0,0,0], k =0, failed I realised, I need to store the no of times the sum k happened in hashmap. 

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hmap = {}
        count = 0
        Rsum = 0
        for i in range(len(nums)):
            Rsum += nums[i]
            
            if Rsum == k:
                count +=1
            
            if Rsum - k in hmap:
                # length = i - hmap[Rsum -k] 
                count += hmap[Rsum - k]
            
            if Rsum not in hmap:
                hmap[Rsum] = 1
                #hmap[Rsum] = i
            else:
                hmap[Rsum] += 1
                
        return count