class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        sumArray = [0]
        count = 0
        for i in range(len(nums)):
            sumArray.append(sumArray[i] + nums[i])
        res = defaultdict(int)
        for j in range(len(sumArray)):
            if sumArray[j] - k in res:
                count += res[sumArray[j] - k]
            res[sumArray[j]] += 1

        return count
