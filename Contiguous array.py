class Solution:
    
    def findMaxLength(self, nums: List[int]) -> int:
        count=0
	max_len=0

	d={}
	d[0]=-1
        for i in range(len(nums)):
            if nums[i]==1:
		count = count + 1
	    else:
		count = count - 1

	    if count not in d:
		d[count]=i
	    else:
		max_len=max(max_len,i-d[count])

         return max_len
