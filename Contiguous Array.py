#Time Complexity :O(n) (n+k)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes

#Intutuion
#We will count by taking 0 as '-1' and 1 as +'1'
#We will use running map to store the 1st occurence of that COUNT value and caluclate length
#every time it appears from its first occurence which gives max legth
#map={0:-1} -> we intialize map with 0 as -1 because it'll skip the first ocuurencre 

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        length=0
        c=0 #This will store the current sum. 
        map={0:-1} # we intialize 0 as -1 because it'll skip the first ocuurencre 
                    #what skip??explain??
        for i in range(len(nums)):
            val=nums[i]
            if val is 0:    #If it is zero, we will decrement the C, Vice versa. 
                c-=1
            else:
                c+=1

            if c in map:
                length=max(length, i-map[c])
            else:
                map[c]=i #We will store the index of the counter when it appeared for the first time, so it will be helpful to track the Rmax. 
        return length
                
