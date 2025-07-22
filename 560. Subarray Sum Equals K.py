# Time Complexity : O(n)
# Space Complexity : O(n)
def subarraySum(nums: list[int], k: int) -> int:
        if nums is None:
            return 0
        rSum = 0
        count = 0
        map={0:1}
        for num in nums:
            rSum = rSum + num
            comp = rSum - k
            if comp in map:
                count = count + map[comp]
            map[rSum] = map.get(rSum, 0) + 1
        return count
print(subarraySum(nums = [1,2,3], k = 3))