"""
Time Complexity -> O(n)
Space Complexity -> O(n)
Logic
We use a prefix sum approach here. Every time,we add to prefix and check if it equals the k. If yes
update the count variable. If not, we check if prefix-k is present in the hashmap and update count accourdingly.
Eventually we update the hashmap with the new count for the prefix.
The idea is if we get to a particular sum and sum-k is present in the hashmap, it means k is present in the prefix sum

"""
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        prefix_sum = 0
        hash_map = {}

        for num in nums:
            prefix_sum += num
            if prefix_sum == k:
                count+=1
            diff = prefix_sum-k
            if diff in hash_map:
                count += hash_map[diff]
            hash_map[prefix_sum] = hash_map.get(prefix_sum, 0) + 1
        return count