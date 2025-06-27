'''
525 Contiguous array
https://leetcode.com/problems/contiguous-array/description/

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Example 1:
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

Example 2:
Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Example 3:
Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.

Example 4:
Input: nums = [1,1,0,0,1,1,0,1,1]
Output: 6
Explanation: Possible subarrays are [[1, 2], [0, 3], [1, 4], [2, 5], [1, 6], [2, 7]]. Longest [1,6],[2,7]]

Example 5:
Input: nums = [1,1,0,0,1,1,0,1,1]
Output: 6
Explanation: Possible subarrays are [[1, 2], [0, 3], [1, 4], [2, 5], [1, 6], [2, 7]]. Longest [1,6],[2,7]

Example 6:
Input: nums = [0,0,1, 1,1,0, 0,1,1, 1,1,0, 0,0,1]
Output: 14
Explanation: Possible subarrays are [[1, 2], [0, 3], [0, 5], [1, 6], [0, 7], [5, 8], [10, 11], [5, 12], [0, 13], [5, 14]]. Longest [13,0]

Example 7:
Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: Possible subarrays are [[0, 1], [5, 6], [4, 7], [3, 8]]. Longest [3,8]

Solution:
1. Brute Force: Find all subarrays O(N^2). For each subarray, count the subarrays with equal no. of 0's and 1's O(N).
Time: O(N^2 * N) = O(N^3)

2. Hashing and Running/Cumulative/Prefix sum:
Compute a running sum (aka cumulative sum or prefix sum) at each index which is the sum of the array (A) from 0 to that index. Why compute running sum? Because it helps generate the sum of any contiguous subarray in O(1) time instead of    O(N) using the formula:
sum[i,j] = RS[j] - RS[i-1],
where
sum[i,j] = A[i] + A[i+1] ... + A[j]
RS[j] = A[0] + ... + A[i-1] +  A[i] + A[i+1] ... + A[j]
RS[i-1] = A[0] + ... + A[i-1]

While computing RS, replace the 0's in the array by -1.
array = 0  1 1 1 1 1 0 0 0
index = 0  1 2 3 4 5 6 7 8
RS    = -1 0 1 2 3 4 3 2 1

Note that whenever two indices have the same RS value, there are equal no. of 0's and 1's between them. Eg. Since RS[3]=2 and RS[7]=2, there are two 1's and two 0's between [4, 7]. In general, if R[i] = R[j], then there are equal no. of 0's and 1's in [i+1, j]. The no. of 0's or 1's are = j - (i+1) + 1 = j-i
Another point to note: Why did we convert 0 to -1 during RS computation? Because, if we did not convert, the RS values will be an increasing sequence of numbers which makes it harder to infer the start and end index of the subarray containing equal 0's and 1's.
Hence, first compute the running sum at each index. Traverse from left to right and check at each index if the running sum at that index was previously encountered in some previous index. To maintain a running sum of previous indices, we maintain a hash map of <RS[j], j>
Step 1: Compute the running sum (RS) at each index.  Let j = 0
Step 2: Compute RS[j].
Step 3: Check if RS[j] is a key in hash map.
        yes: This means RS[j] was already seen at some previous index. Let that previous index be i. Then the subarray A[i+1] ... , A[j] contains equal no. (=j-i) of 1's and 0's .
        no: Add RS[j] to hash map. H[RS[j]] = j
Step 4: j = j + 1 until j < N

Edge Case: Let A = [0, 1], PS = [-1, 0], H: {}
i = 0, PS[0] = -1. -1 not in hash -> H: {-1, 0}
i = 1, PS[1] = 0. 0 not in hash -> H: {-1:0, 0:1}.
Thus, we did not discover that subarray [0,1] contains one 0 and one 1.

Let's initialize H: {0:-1} now.
i = 0, PS[0] = -1. -1 not in hash -> H: {0:-1, -1, 0}
i = 1, PS[1] = 0.   0 in hash -> subarray = [-1+1, 1] = [0,1]

Time: O(N), Space: O(N)
https://www.youtube.com/watch?v=jIYztzByDus
'''
def get_num(A, i):
    if A[i] == 0:
        return -1
    return 1

def contiguous_array_return_subarrays(A):
    '''
    Return all possible contiguous subarrays with equal 0s and 1s
    and the max length of the subarray
    '''
    N = len(A)
    if N <= 1:
        return -1, []

    # initializations
    h = {}
    num = get_num(A, 0)
    PS = [num]
    h[num] = 0
    max_len = float('-inf')
    sub_arrays = []

    for i in range(1,N): # O(N)
        num = get_num(A,i)

        PS.append(PS[i-1]+num)
        if PS[i] == 0:
            sub_arrays.append([0,i])
        elif PS[i] in h:
            sub_arrays.append([h[PS[i]]+1,i])
        else:
            h[PS[i]] = i
        if sub_arrays:
            l = sub_arrays[-1][1] - sub_arrays[-1][0] + 1
            max_len = max(max_len, l)
    return max_len, sub_arrays

def contiguous_array_return_maxlen(A):
    '''
    Return the max length of the subarray with equal 0s and 1s
    '''
    N = len(A)
    if N <= 1:
        return -1

    # initializations
    max_len = float('-inf')
    # prefix sum/running sum = 0
    ps = 0
    # map <prefix sum: index>
    h = {0: -1}
    for j in range(N): # O(N)
        ps += get_num(A,j)
        if ps in h:
            i = h[ps]
            this_len = j - i
            max_len = max(max_len, this_len)
        else:
            h[ps] = j
    return max_len

def run_contiguous_array():
    A = [0, 1]
    max_len, sub_arrays = contiguous_array_return_subarrays(A)
    print(f"\nA = {A}")
    print(f"max len = {max_len}, subarrays = {sub_arrays}")

    A = [1, 1, 0, 0, 1, 1, 0, 1, 1]
    max_len, sub_arrays = contiguous_array_return_subarrays(A)
    print(f"\nA = {A}")
    print(f"max len = {max_len}, subarrays = {sub_arrays}")

    A = [0,0,1, 1,1,0, 0,1,1, 1,1,0, 0,0,1]
    max_len, sub_arrays = contiguous_array_return_subarrays(A)
    print(f"\nA = {A}")
    print(f"max len = {max_len}, subarrays = {sub_arrays}")

    A = [0,1,1,1,1,1,0,0,0]
    max_len, sub_arrays = contiguous_array_return_subarrays(A)
    print(f"\nA = {A}")
    print(f"max len = {max_len}, subarrays = {sub_arrays}")

    A = [0, 1]
    max_len = contiguous_array_return_maxlen(A)
    print(f"\nA = {A}")
    print(f"max len = {max_len}")

    A = [1, 1, 0, 0, 1, 1, 0, 1, 1]
    max_len = contiguous_array_return_maxlen(A)
    print(f"\nA = {A}")
    print(f"max len = {max_len}")

    A = [0,0,1, 1,1,0, 0,1,1, 1,1,0, 0,0,1]
    max_len = contiguous_array_return_maxlen(A)
    print(f"\nA = {A}")
    print(f"max len = {max_len}")

    A = [0,1,1,1,1,1,0,0,0]
    max_len = contiguous_array_return_maxlen(A)
    print(f"\nA = {A}")
    print(f"max len = {max_len}")

run_contiguous_array()