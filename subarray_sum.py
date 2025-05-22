# count number of subarrays whose sum equals to the target
# rsum method has been used
# time complexity will be O(n)
# space complexity will be O(n) - since hashmap will keep max n elements
mmap = {}
def find_number_of_subarrays(nums, target) -> int:
    rsum = 0
    totalCount = 0
    mmap[0] = 1
    for num in nums:
        rsum += num
        if abs(target-rsum) in mmap:
            totalCount += mmap[abs(target-rsum)]
        if rsum not in mmap:
            mmap[rsum] = 1
        else:
            mmap[rsum] += 1
    return totalCount


if __name__ == "__main__":
    nums = [1,2,3]
    target = 3
    print(find_number_of_subarrays(nums, target))