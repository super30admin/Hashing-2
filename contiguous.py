# Time Complexity : O(n)
# Space Complexity : O(n)
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        Dict = {}
        maxlen = 0
        currsum = 0

        Dict[0] = -1

        for x in range(len(nums)):
            if nums[x] == 0:
                currsum += 1
            else:
                currsum -= 1

            if currsum in Dict:
                maxlen = max(maxlen, x - Dict.get(currsum))
            else:
                Dict[currsum] = x

        return maxlen