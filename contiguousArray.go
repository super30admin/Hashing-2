// Time Complexity : O(n)
// Space Complexity : O(n) for the running sum lookup map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*

Approach: we use a "running sum" pattern where we store the sum of the given
array up to the index we are at. Specifically in this problem, instead of
directly storing the running sum, we add 1 to sum if it's a "1" and subtract 1
from sum if it's a "0".
We use a hashmap to store the starting index
of the first occurrence of a given running sum. This is because of the fact that
between 2 same running sum values, we have an equal number of 1's and 0's
(balanced contiguous sub-array).
To maximize this range of sub-array indices, we also keep a count of the
furthest index among any running sum ranges encountered till now.

*/

package main

func findMaxLength(nums []int) int {
	if len(nums) <= 1 {
		return 0
	}

	maxLen := 0
	rSum := 0
	m := map[int]int{
		// assume default value is sum 0 at index -1
		// because we're calculating running sum from index 0
		0: -1,
	}

	for i, n := range nums {
		if n == 0 {
			rSum--
		} else if n == 1 {
			rSum++
		}
		// check if this sum was already encountered
		if index, ok := m[rSum]; ok {
			// if it was, check and update max range of subarray
			if maxLen < i-index {
				maxLen = i - index
			}
		} else {
			m[rSum] = i
		}
	}

	return maxLen
}
