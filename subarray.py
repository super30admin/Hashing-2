#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        Dict = {}
        count = 0
        currsum = 0
        Dict[0] = 1
        compliment = 0
        for x in range(len(nums)):
            currsum += nums[x]
            compliment = currsum - k

            if compliment in Dict:
                count += Dict.get(compliment)

            Dict[currsum] = Dict.get(currsum, 0) + 1
        return count