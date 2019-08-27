def sumofsubarray(nums, k):
    ans = 0
    data = dict()
    data[0] = 1
    total = 0
    for i in range(len(nums)):
        total += nums[i]
        if (total - k) in data:
            ans += data[total-k]
        data[total] = data.get(total, 0) + 1
    return ans