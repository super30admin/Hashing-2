"""
Rasika Sasturkar
Time Complexity: O(n)
Space Complexity: O(n)
"""


def subarraySum(nums, k) -> int:
    """
    We are storing the difference i.e. y = z-x, where z is the sum
    and x is a number in the list. So, if y is already present in the
    hashmap we increment the count, if not we add it to the hash map,
    and we also increment the count. In this way, we will get all the
    subarrays that will the sum k.
    """
    array_map = {0: 1}  # dummy key,value
    r_sum = 0
    count = 0

    for i in range(len(nums)):
        r_sum += nums[i]
        if (r_sum - k) in array_map:
            count = count + array_map[r_sum - k]
        if r_sum not in array_map:
            array_map[r_sum] = 0
        array_map[r_sum] += 1
    return count


def main():
    """
    Main function - an example from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(subarraySum(nums=[1, 1, 1], k=2))  # returns 2
    print(subarraySum(nums=[1, 2, 3], k=3))  # returns 2


if __name__ == "__main__":
    main()
