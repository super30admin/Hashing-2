# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution(object):
    def subArraySum(self, arr, k):
        res = {0: 1}          #Dummy value
        sm, count = 0, 0
        for i in range(0, len(arr)):
            sm += arr[i]        #Cumulative sum

            comp = sm - k     
            if comp in res:     #if the comp value is present increae the count
                count += res[comp]
            if sm not in res:   #increase the sm count if present in res
                res[sm] = 1
            else:
                res[sm] += 1
        return count


s = Solution()
print s.subArraySum([1,1,1], 2)