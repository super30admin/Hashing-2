"""
Space Complexity: O(N)

Time Complexity: O(N)

Explanation: We keep a running sum of all the numbers, and at a particular index, we check if the target exists in the map, if yes, we add the frequencies of how many times it occured and add it to the solution, gettign teh solution in linear time. 

"""
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        rsum = 0
        mp = {}
        mp[0] = 1
        ans = 0
        for i, n in enumerate(nums): 
            rsum += n
            if rsum - k in mp: 
                ans += mp[rsum - k]
            if rsum in mp: 
                mp[rsum]+=1
            else:
                mp[rsum] = 1


        return ans

