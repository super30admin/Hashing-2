#Runningsum is obtained which is used to determine the indexes of the longest contiguous array. Values of the runningsum are stored in a hashmap and then
#maximum length value is obtained if there a bigger contiguous array is found 
#Time complexity: O(n) and space complexity is O(n)
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if (nums==None):
            return 0
        maxlength=0
        hashmap={}
        rsum=0
        hashmap[0]=-1
        for i in range(len(nums)):
            if nums[i]==0:
                rsum=rsum-1
            else:
                rsum=rsum+1
            if rsum in hashmap.keys():
                temp=i-hashmap[rsum]
                if(temp>maxlength):
                    maxlength=temp
            else:
                hashmap[rsum]=i
        return maxlength