"""
Rasika Sasturkar
Time Complexity: O(n)
Space Complexity: O(n)
"""


def findMaxLength(nums) -> int:
    """
    We keep a track of the running sum, if it is 0 we decrement it else we
    increase the rsum by 1. Next, we check if rsum was present in our hashmap.
    If it is present, this means we have our y (y = z-x) and we get the max
    between our y and current count. If rsum is not present in hashmap we add
    to keep track of its occurrence.
    """
    array_map = {0: -1}
    r_sum = 0
    count = 0

    for i in range(len(nums)):
        if nums[i] == 0:
            r_sum -= 1
        else:
            r_sum += 1
        if r_sum in array_map:
            count = max(count, i - array_map[r_sum])
        else:
            array_map[r_sum] = i

    return count


def main():
    """
    Main function - an example from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(findMaxLength(nums=[0, 1]))  # returns 2
    print(findMaxLength(nums=[0, 1, 0]))  # returns 2


if __name__ == "__main__":
    main()
