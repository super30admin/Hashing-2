// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

//Create a hashset, iterate over the string, if the set does not contain the value, add it. If it does then increase the count by 2 and remove the value from the hashset.

class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashset=set()
        count=0
        for i in s:
            if i not in hashset:
                hashset.add(i)
            else:
                count += 2
                hashset.remove(i)
        if len(hashset) != 0:
            count += 1
        return count


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
// Using the running sum pattern. If the rsum is already obtained earlier, we compare the max between current max and the first occurence of the running sum

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        
        rsum = -1
        hashmap = {}
        hashmap[-1] = -1
        largest = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                rsum -= 1
            if nums[i] == 1:
                rsum += 1
            
            if rsum not in hashmap:
                hashmap[rsum] = i 
            else:
                largest = max(largest,i-hashmap[rsum])
        return largest


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
// similar to above problem, but this time storing count of complement occurences in hashmap instead of indexes

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        rsum = 0
        map = {0:1}

        for i in nums:
            rsum += i
            comp = rsum - k
            
            if comp in map.keys():
                count = count + map[comp]
                
            if rsum in map.keys():
                map[rsum] += 1
            else:
                map[rsum] = 1
        return count
        