'''
560 Subarray Sum Equals K
https://leetcode.com/problems/subarray-sum-equals-k/description/

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k. A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2

Example 3:
Input: nums = [3, 4, 7, -2, 2, 1, 4, 2], k = 7
Output: 5
Explanation:
[3, 4] (index 0 to 1)
[7] (index 2)
[7, -2, 2] (index 2 to 4)
[2, 1, 4] (index 4 to 6)
[1, 4, 2] (index 5 to 7)

Constraints:
    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107

Solution:
1. Brute Force: Find all subarrays O(N^2). For each subarray, count the sum of the elements O(N).
Time: O(N^2 * N) = O(N^3)

2. Hashing and Running/Cumulative/Prefix sum:
Compute a running sum (aka cumulative sum or prefix sum) at each index which is the sum of the array (A) from 0 to that index. Why compute running sum? Because it helps generate the sum of any contiguous subarray in O(1) time instead of    O(N) using the formula:
SS[i,j] = PS[0, j] - PS[0, i-1], j >= i
where
subarray sum = SS[i,j] = sum(A[i:j]), j inclusive
prefix sum = PS[0, j] = sum(A[0:j])
            PS [0, i-1] = sum(A[0:i-1])

|---------------- PS[O:j] --------------|
A[0] A[1] A[2] .... A[i-1] A[i]  ....   A[j] A[j+1] ... A[end]
|---   PS[O:i-1] ------|
                            |--SS[i,j]--|

Example:
array = 3  4  7  2  -3  1  4  2  0  1
index = 0  1  2  3   4  5  6  7  8  9
PS    = 3  7 14  16  13 14 18 20 20 21
Let k = 7 (target sum)

We are looking for a pair of indices whose sum is k. In other words,
we are looking for SS[i,j]=k => PS[j] - PS[i-1] = k.
This equation is satisfied by the following pairs:
PS[2] - PS[1] = 14 - 7 = 7
PS[5] - PS[1] = 14 - 7 = 7
PS[9] - PS[5] = 21 - 14 = 7
PS[9] - PS[2] = 21 - 14 = 7
PS[8] - PS[4] = 20 -13 = 7
PS[7] - PS[4] = 20 -13 = 7
Hence, there are 6 such pairs of indices or in other words 6 such subarrays with sum 7.

Let z = SS[i,j], x = PS[0, j], y = PS[0, i-1]
Hence, z = x - y

If we scan the array from left to right using index j, we can calculate the value of x (running sum/prefix sum) at each index. We maintain a hash map
with key = x and freq count of x as the value (and not the index where x occurred)

index = 0  1  2  3   4  5  6  7  8  9
array = 3  4  7  2  -3  1  4  2  0  1
PS    = 3  7 14  16  13 14 18 20 20 21
Let k = 7 (target sum)
hash map (h) = {3:0, 7:1, 14:2, 16:1, 13:1, 18:1, 20:2, 21:1}


We know z = k and the value of x(=PS[j]) at each index j in the hash map h. All we need to find out is whether y, where y = x - z = PS[j] - k, exists in the hash map or not. Once we know y (= PS[i-1]), we are guaranteed that we have found a sub array between [i,j] such that the sum of elements of sub array A[i,j] = SS[i,j] = k.

Example:
At index j = 2, x = 14. Hence, y = x - z = 14 - 7 = 7.
Does h[7] exist? Yes, at index = 1
This means, there is a big array A[0:2] and a small array A[0:1]
such that sum(A[0:2]) - sum(A[0:1]) = sum([3,4,7]) - sum([3,4]) = sum([7]) = 7
        |--x---|
index = 0   1  2  3   4  5  6  7  8  9
array = 3   4  7  2  -3  1  4  2  0  1
PS    = 3   7 14  16  13 14 18 20 20 21
        |-y-|
desired sub-array = [7] (count = h[7] = 1)

At index j = 9, x = 21. Hence, y = x - z = 21 - 7 = 14.
Does h[14] exist? Yes. At two places.
        |------------x--------------|
index = 0  1  2  3   4  5  6  7  8  9
array = 3  4  7  2  -3  1  4  2  0  1
PS    = 3  7 14  16  13 14 18 20 20 21
        |-y--|
        |------y--------|
desired sub-arrays = [[2  -3  1  4  2  0  1], [4  2  0  1]] (count = h[14] = 2)

We increment the total count of desired sub-arrays by
h[x-z] if x-z exist in the hash map.

x = 0, total_count = 0

For each j in 0:len(array)
    Step 1: Compute the current running sum (PS[j]) at index j
            x += PS[j]

    Step 2: Compute the k-complement of x, y = x - k

    Step 3: Check if y is a key in hash map.
            yes: This means key = x - k was already seen at some previous index.
            total_count += H[x-k]

    Step 4: Update the freq count of x in hash map.
            H[x] = H[x] + 1
end for

Step 5: return total_count

Edge Case: Let nums = [3, 4], x = [3, 7], H: {3: 1, 4: 1}
The key we search for in H is = PS[1] - 7 = 0
Since 0 is not present in H yet, count = 0. But the array [3, 4] itself sums to 7. Hence, the count must have been 1. To fix this problem, we initialize H[0] = 1 before we run Step 1.

Time: O(N), Space: O(N)
https://www.youtube.com/watch?v=qltC064ZyXM
https://youtu.be/QedKy3SynwM?t=5354
'''

from collections import defaultdict

def subarray_sum_equals_k_all_possible(nums, K):
    '''
    Return all possible subarrays with sum K
    Not required but I did it anyways to verify the correctness of the subarrays
    '''
    N = len(nums)
    if N == 0:
        return -1
    h = defaultdict(list)
    PS_curr = 0
    subarrays=[]
    for j in range(N):
        PS_curr += nums[j]
        PS_tgt = PS_curr - K
        if PS_tgt == 0:
            subarrays.append([0, j])

        if PS_tgt in h:
            end = j
            for i_minus_1 in h[PS_tgt]:
                start = i_minus_1 + 1
                subarrays.append([start, end])
        h[PS_curr].append(j)

    return subarrays

def subarray_sum_equals_k_count_1(nums, k):
    '''
    Return the count of all possible subarrays with sum k using 2 for loops.
    Less compact, simpler to understand. Fails a test case where nums = [1], k = 0, output = 1, but ans = 0
    '''
    N = len(nums)
    if N == 0:
        return 0
    h = defaultdict(int)
    h[0] = 1 # at this point, running sum = 0 has occurred once
    x = 0 # PS[j]
    for num in nums:
        x += num
        h[x] += 1

    x = 0
    total_count = 0
    for num in nums:
        x += num
        y = x - k
        if y in h:
            total_count += h[y]

    return total_count

def subarray_sum_equals_k_count_2(nums, k):
    '''
    Return the count of all possible subarrays with sum k using a single for loop. More compact. Passes all test cases
    The only difference between the two for loop vs one for loop
    is the placement of storing the running sum in hash map.
    First check if k-complement exists in hash map.
    Then, increment the freq count of the running sum in hash map.
    '''
    N = len(nums)
    if N == 0:
        return 0
    h = defaultdict(int)
    h[0] = 1 # at this point, running sum = 0 has occurred once
    x = 0 # PS[j]
    total_count = 0
    for num in nums:
        # Step 1: Compute running sum
        x += num

        # Step 2: Compute y (k-complement of the running sum)
        y = x - k

        # Step 3: Check if complement present in map.
        # If present, update total count
        if y in h: #
            total_count += h[y]

        # Step 4: Increment the count of the running sum in hash map
        h[x] += 1

    return total_count


def run_subarray_sum_equals_k():
    tests = [([1,1,1], 2, 2),
             ([3, 4, 7, -2, 2, 1, 4, 2], 7, 6),
             ([1], 0, 0),
             ([3, 1, 2, 4], 6, 2),
             ([6, -2, 2, 4], 6, 3),
             ([6, -2, 2, 0, 4, 6], 6, 5),
             ([9, 4, 0, 20, 3, 10, 5], 33, 3),
    ]
    for test in tests:
        nums, k, ans = test[0], test[1], test[2]
        subarrays = subarray_sum_equals_k_all_possible(nums, k)
        count1 = subarray_sum_equals_k_count_1(nums, k)
        count2 = subarray_sum_equals_k_count_2(nums, k)
        print(f"\nnums = {nums}")
        print(f"subarrays = {subarrays}, k = {k}")
        print(f"Num subarrays with sum {k} = {count1, count2}")
        print(f"Pass: {ans == count1 == count2}")

run_subarray_sum_equals_k()
