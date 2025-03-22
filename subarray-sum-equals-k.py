// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Visualizing the map used for storing the rsum:count


// Your code here along with comments explaining your approach
// 1. Create a map to store the runningSum: count mapping (count indicating how many times the rsum has occured so far)
// 2. Iterate through the arry. Find the running sum. If the complement (running_sum - k) is in the map, then update add the complement's value in the map to count (indicating that we have encountered a subarray that matches the target sum)
// 3. Update rsum's count by 1 in the map (indicating that we have encountered the running sum now)                                                                    

from collections import defaultdict
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        mapp = defaultdict(int)
        mapp[0] = 1  
        
        summ = 0  
        count = 0  
        
        for num in nums:
            summ += num
            if summ - k in mapp:
                count += mapp[summ - k]
            mapp[summ] += 1
        
        return count
            



        
