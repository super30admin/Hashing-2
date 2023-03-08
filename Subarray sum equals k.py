# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if len(nums) < 2:
            if nums[0] == k:
                return 1
            return 0
        dic = {0:1}
        currsum = 0
        answer = 0
        for i in range(len(nums)):
            currsum += nums[i]
            temp = currsum - k

            if temp in dic:
                answer += dic[temp]

            if currsum not in dic:
                dic[currsum] = 1

            else:
                dic[currsum] += 1

        # print(dic)
        return answer
