# finding maximum length of balanced subarray 
# Time complexity is O(n)
# Space complexity will be O(n) since hash map could contain max n elements
mmap = {}
def find_length_of_max_balanced_subarray(nums):
    mmap[0] = -1
    rsum = 0
    max_count = 0
    for i, num in enumerate(nums):
        if num == 0:
            rsum -= 1
        else:
            rsum += 1
        if rsum not in mmap:
            mmap[rsum] = i
        else:
            count = i - mmap[rsum]
            max_count = max(max_count, count)
    return max_count

if __name__ == "__main__":
    nums = [0,1,0,1,0,1]
    print(find_length_of_max_balanced_subarray(nums))