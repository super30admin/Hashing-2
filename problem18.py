#time complexity :O(n)
#Space complexity :O(n)

#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

# we are going to check subarray sum equals k here by using hash map /dictionary
#fisrtly im checking elements , if it is then adding in to currentsum , then substracting the current sum with k, if current sum in dict then increment the counter

class Solution(object):
    def subarraySum(self, nums, k):
        
        currSum = 0
        Count = 0
        dict = {0:1}  #previous sums     #dictionary , i.e hashmap   
        
        for i in nums:
            
            currSum += i
            
            if (currSum - k) in dict:
                Count += dict[currSum - k]
                
            if currSum in dict:
                dict[currSum] += 1
            else:
                dict[currSum] = 1

        return Count


