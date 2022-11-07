#time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: yes
#If we have a running sum and for 2 indexs i,j such that j>i, then sum from i to j can be written
# as running_sum[j]-running_sum[i-1]. Count is incremented by +1 and -1 depending on whether 
#the input is 1 or 0. This count is stored in a hashmap if they key does not exist( value will
#be the index). IF this count is already present in hashmap this means we have encountered
# a window with equal 0 and1's. So subtarct the current index from the index(value) given by the 
#'count' key. save this length if it is the maximum. 
class Solution:
    def findMaxLength(self, nums) -> int:
        count=0
        occurrence={0:-1}
        best=0
        for i in range(len(nums)):
            if(nums[i]==0):
                count-=1
            else:
                count+=1
            if(count in occurrence):
                best=max(best,i-occurrence[count])
            else:
                occurrence[count]=i
        return best

s=Solution()
nums=[0,1,0,1,1,0,0]
print(s.findMaxLength(nums))