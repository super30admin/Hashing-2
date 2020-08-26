# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution(object):
    def continousArray(self, arr):
        count = 0
        res = {}
        mx = 0
        for i in range(0, len(arr)):
            if arr[i] == 0:     #Check for value of array
                count += 1
            else:
                count -= 1
            
            if count == 0:      
                mx = i + 1
                
            if count not in res:    #Store count in map if not present for the first index
                res[count] = i
            else:
                mx = max(mx, i - res[count])     #If the same count is present then change the max value
        return mx

s = Solution()
print s.continousArray([0,1])