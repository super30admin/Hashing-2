#Time Complexity: 0(n)
#Space Complexity:O(n)
#Did it run on leetcode: Yes
class Solution:
    def findMaxLength(self, nums) -> int:
        #Initializing a Dictionary
        hashmap = dict()
        hashmap[0] = -1
        rsum = 0
        maxi = 0
        for i in range(len(nums)):
            if (nums[i] == 1):
                #If the running sum is equal to one then add one to the running sum
                rsum = rsum + 1
            else:
                # Or else subtract one from the running sum
                rsum = rsum - 1
            if (hashmap.get(rsum) == None):
                #If there is no element in the hashmap location then insert the element in the array location
                hashmap[rsum] = i
            else:
                #Else update the maximum of the element
                maxi = max(maxi, i - hashmap.get(rsum))
                #Finally return the maximum value
        return maxi
