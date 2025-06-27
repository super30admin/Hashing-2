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

Constraints:
    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107

Solution:
1. Brute Force: Find all subarrays O(N^2). For each subarray, count the sum of the elements O(N).
Time: O(N^2 * N) = O(N^3)

2. Hashing and Running/Cumulative/Prefix sum:
Compute a running sum RS (aka cumulative sum or prefix sum) at each index which is the sum of the array (A) from 0 to that index. Why compute running sum? Because it helps generate the sum of any contiguous subarray in O(1) time instead of    O(N) using the formula:
sum[i,j] = RS[j] - RS[i-1],
where
sum[i,j] = A[i] + A[i+1] ... + A[j]
RS[j] = A[0] + ... + A[i-1] +  A[i] + A[i+1] ... + A[j]
RS[i-1] = A[0] + ... + A[i-1]

array = 3  4  7  2  -3  1  4  2  0  1
index = 0  1  2  3   4  5  6  7  8  9
RS    = 3  7 14  16  13 14 18 20 20 21
Let K = 7 (target sum)

We are looking for a pair of indices whose sum is K. In other words,
we are looking for sum[i,j]=K => RS[j] - RS[i-1] = K.
This equation is satisfied by the following pairs:
RS[2] - RS[1] = 14 - 7 = 7
RS[5] - RS[1] = 14 - 7 = 7
RS[9] - RS[5] = 21 - 14 = 7
RS[9] - RS[2] = 21 - 14 = 7
RS[8] - RS[4] = 20 -13 = 7
RS[7] - RS[4] = 20 -13 = 7
Hence, there are 6 such pairs of indices or in other words 6 such subarrays with sum 7.

If we scan the array from left to right using index j, we would know the value of RS[j] at each index. Then, RS[i-1] = RS[j] - K. We know what RS[i-1] but we do not know what "i-1" is. Thus, we are left with finding i-1 which can be easily done by maintaining a hash map. Since we want to know the counts of RS[i-1], we store RS[i-1] as the key and the frequency of occurrence of RS[i-1] as the value (instead of index i-1) in the hash map.

Step 1: Compute the running sum (RS) at each index. count = 0. Let j = 0
Step 2: Compute RS[j].
Step 3: Check if RS[j] - K is a key in hash map.
        yes: This means key = RS[j] - K was already seen at some previous index.
        count = count + H[RS[j] - K]
Step 4: Add RS[j] to hash map. H[RS[j]] += 1
Step 4: j = j + 1 until j < N

Edge Case: Let A = [3, 4], PS = [3, 7], H: {3: 1, 4: 1}
The key we aresearch for in H is = RS[1] - 7 = 0
Since 0 is not present in H yet, count = 0. But the array [3,4] itself sums to 7. Hence, the count must have been 1. To fix this problem, we initialize H[0] = 1 before we run Step 2.

Time: O(N), Space: O(N)
https://www.youtube.com/watch?v=qltC064ZyXM
'''

from collections import defaultdict

def subarray_sum_equals_k_all_possible(A, K):
    '''
    Return all possible subarrays with sum K
    Not required but I did it anyways to verify the correctness of the subarrays
    '''
    N = len(A)
    if N == 0:
        return -1
    h = defaultdict(list)
    PS_curr = 0
    subarrays=[]
    for j in range(N):
        PS_curr += A[j]
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

def subarray_sum_equals_k_count(A, K):
    '''
    Return the count of all possible subarrays with sum K
    '''
    N = len(A)
    if N == 0:
        return 0
    h = defaultdict(int)
    h[0] = 1
    PS = 0 # prefix sum = 0
    count = 0
    for j in range(N):
        PS += A[j]
        if PS - K in h:
            count += h[PS -K]
        h[PS] += 1
    return count

def run_subarray_sum_equals_k():
    A = [3, 1, 2, 4]
    K = 6
    subarrays = subarray_sum_equals_k_all_possible(A, K)
    count = subarray_sum_equals_k_count(A, K)
    print(f"\nA = {A}")
    print(f"subarrays = {subarrays}")
    print(f"Num subarrays with sum {K} = {count}") # 2


    A = [6, -2, 2, 4]
    K = 6
    subarrays = subarray_sum_equals_k_all_possible(A, K)
    count = subarray_sum_equals_k_count(A, K)
    print(f"\nA = {A}")
    print(f"subarrays = {subarrays}")
    print(f"Num subarrays with sum {K} = {count}") # 3


    A = [6, -2, 2, 0, 4, 6]
    K = 6
    subarrays = subarray_sum_equals_k_all_possible(A, K)
    count = subarray_sum_equals_k_count(A, K)
    print(f"\nA = {A}")
    print(f"subarrays = {subarrays}")
    print(f"Num subarrays with sum {K} = {count}") # 5


    A = [9, 4, 0, 20, 3, 10, 5]
    K = 33
    subarrays = subarray_sum_equals_k_all_possible(A, K)
    count = subarray_sum_equals_k_count(A, K)
    print(f"\nA = {A}")
    print(f"subarrays = {subarrays}")
    print(f"Num subarrays with sum {K} = {count}") # 3

run_subarray_sum_equals_k()
