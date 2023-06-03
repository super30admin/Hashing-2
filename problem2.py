#Time Complexity : O(n)
#Space Complexity : O(n)
#Code ran successfully on the leetcode
#Faced no problems while developing the code

#Program to find the maximum length of a contiguous subarray with an equal number of 0's and 1's
class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #Creating a hashmap to store running sum as key value and the initial index where running sum value occurs
        self.HashMap={}
        #To handle the edge case, we are initially inserting 0 and -1 as key vlaue pair
        self.HashMap[0]=-1
        #Initializing rSum and Maximum values to 0
        self.rSum=0
        self.Maximum=0
        #We will be iterating through each value in the nums array
        for i in range(0,len(nums)):
            #if the nums[i] is equal to 0, we will subtract 1 from the rSum 
            if(nums[i]==0):
                self.rSum-=1
            #if the nums[i] is equal to 1, we will add 1 to the rSum 
            elif(nums[i]==1):
                self.rSum+=1
            #If the rSum value is present in the HashMap, we will subtract the current index value from the initial index value from hashmap
            if(self.rSum in self.HashMap):
                self.val=i-self.HashMap[self.rSum]
                #If the val is greater than maximum, then we will update the self.maximum vakue
                if(self.val>self.Maximum):
                    self.Maximum=self.val
            #If the rSum value is not present in the HashMpa, we will add an entry into the HashMap
            else:
                self.HashMap[self.rSum]=i
        #Retruning the maximum lenght of a contiguous array
        return self.Maximum