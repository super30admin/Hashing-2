# Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no

class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        ## for this problem we need to look at all the sub array whose sum is k, naive way is tending towards n^3
        ## to be able to do it in a single pass, we need some way where we can look at all the past subarray without iterating 
        ## here the prefix sum technique comes in handy
        ## Start by having a hashmap which will be used to store the running sum and how many times it has occured
        ## hashmap = {0:1} ## diff,ways ## adding 0 as base case because 0 has happenend once and this will help us 
        ## to catch the index =0 cases as well. 
        ## iterating over the nums and adding the curSum 
        ## now we can check if the complement of it has happened in the past, which will mean we can increase the 
        ## subbarray count by the times it has happened +1 
        ## calculating the sum and getting the value from hashmap
        ## incrementing the value by 1 and putting back in hashmap
        ## finally we exaust the search space and return res
        # curSum =0 
        hashmap = {} ## diff, how many times it has happened
        hashmap[0] = 1
        curSum =0 
        res =0 
        for n in nums:
            curSum +=n
            diff = curSum-k
            res += hashmap.get(diff,0)
            hashmap[curSum] = 1+ hashmap.get(curSum,0)
            
        return res



########################################
# Problem2 (https://leetcode.com/problems/contiguous-array/)
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no

class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        ## prefix sum pattern
        ## continous sum when we see 1 do +1 when encounter 0 do -1
        ## maintain a hashmap for running sum , index
        ## if the running sum exists in the map, replace count with max of existing and index in hashmap, current - previous 
        ## maintain the count to return at the end 

        hashmap={}
        hashmap[0]=-1 ## base case cos we dont want to miss the first index
        count =0 
        rSum =0 
        for i in range(0,len(nums)):
            if nums[i] == 1:
                rSum +=1
            else:
                rSum -=1
                
            if rSum in hashmap:
                count = max(count, i-hashmap.get(rSum))
            else:
                hashmap[rSum] = i 
        
        return count
             

########################################
# Problem3 (https://leetcode.com/problems/longest-palindrome)
# Time Complexity : 
# Space Complexity : 
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


## for checking the longest palindrome I need to check if we already have seen a similar element
## since we need to check for mirror
## we only have to store the elements that we have seen and search in O(1) so the ds here we can use hashset
## maintain a count and a hashset to store the element
## iterate over the string store in hashset if I have seen it for the first time 
## else increment the count by 2, cos pair and remove from the hashset
## if not in hashset and seeing for first time, just add to hashset
## return count if hashset is empty meaning complete mirror and count +1 if hashset not empty telling ud we can choose one value in mid


class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        count =0 
        hashset = set()
        for c in s:
            if c in hashset:
                hashset.remove(c)
                count +=2
            else:
                hashset.add(c)
        
        return count+1 if hashset else count