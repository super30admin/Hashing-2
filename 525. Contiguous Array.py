# Time Complexity : O(n)
# Space Complexity : O(n)
def findMaxLength(nums: list[int]) -> int:
    rSum = 0
    map = {0: -1}
    max_len = 0

    for i in range(len(nums)):
        num = nums[i]
        if num == 0:
            rSum -= 1
        else:
            rSum += 1
        if rSum in map:
            max_len = max(max_len, i - map[rSum])
        else:
            map[rSum] = i
    return max_len

print(findMaxLength(nums = [0,1,1,1,1,1,0,0,0]))