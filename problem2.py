"""
Space Complexity: O(N) as we need to store rsum in a map.

Time Complexity: O(N) as we iterate through the array linearly, in one go. 

Explanation: To avoid nested iterations, we maintain a running sum, and check for the last occured same index in the map, as that array would be balanced, and we utilize hashmap for constant lookups. This way we reduce complexity from O(n^3) to O(n)

"""
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        mp = {}

        mp[0] = -1
        rsum = 0
        ans = 0
        for i, n in enumerate(nums): 
            if n == 0:
                rsum += 1
            else:
                rsum -=1

            if rsum not in mp: 
                mp[rsum] = i
            else:
                ans = max(ans, i - mp[rsum])
        return ans
