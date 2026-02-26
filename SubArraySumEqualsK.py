class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """

        if not nums:
            return 0

        # Map to basically keep track of the complements and their frequency.
        d = dict()

        # Base case
        d[0] = 1

        #Running Sum
        rSum = 0
        # Answer to return.
        total = 0
        for num in nums:
            #Increase the running sum
            rSum = rSum + num
            diff = rSum - k
            # if complement is seen in dict, great! Means we can have a subarray
            # of size k. Add value to the total count.
            if diff in d:
                total = total + d[diff]
        
            #update the frequency of rsum in diff. This can act as a complement
            # later on in the array.
            if rSum not in d:
                d[rSum] = 1
            else:
                d[rSum] += 1
        return total

#TC : O(n)
#SC : O(n)