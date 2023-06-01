#Time Complexity is: O(n)
#Space Complexity is: O(n)
#Code ran successfully on leetcode
#Faced no problems while developing the code

#Program to find sub array of sum k
class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        #creating a hashmap to store the running sum as key and frequency of occurance as value
        self.HashMap={}
        #To handle the edge case we are initially inserting 0 as key and 1 as value
        self.HashMap[0]=1
        #initializing count and running sum(rSum) to 0
        self.count=0
        self.rSum=0
        #Looping through each value in nums
        for i in range(0,len(nums)):
            #adding each value in nums to update rSum
            self.rSum+=nums[i]
            #Here we are checking if the (self.rSum-k) value is present as a key in the HashMap
            if((self.rSum-k) in self.HashMap):
                #If yes then we are going to add the value of that key to the count variable
                self.count+=self.HashMap[self.rSum-k]
            #If the rSum value is not present as a kei in HashMap, we are going to insert an entry
            if(self.rSum not in self.HashMap):
                self.HashMap[self.rSum]=1
            else:
            #If the key is already present, we are going to increment the value by 1
                self.HashMap[self.rSum]=self.HashMap[self.rSum]+1
        #Finally we are returning the count of subarrays whose sum is equal to k
        return self.count