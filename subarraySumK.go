// Time Complexity : O(n)
// Space Complexity : O(n) for the running sum lookup map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*

Approach: we use a "running sum" pattern where we store the sum of the given
array up to the index we are at. We use a hashmap to store the frequency of
occurrence of a particular running sum value (it could occur more than once).
When checking for a sum of "k", we just subtract k from the current running sum
and then lookup in the map to see if we've encountered that sum before.
If we have, we add the overall frequency to our final count.

*/

package main

func subarraySum(nums []int, k int) int {
	if len(nums) == 0 {
		return -1
	}

	rSum := 0
	count := 0
	m := map[int]int{
		// initialize map with default value
		// where we have sum of 0 exactly 1 time
		0: 1,
	}

	for _, n := range nums {
		rSum += n
		// subtract k from current running sum
		// and see if it has been found earlier
		if freq, ok := m[rSum-k]; ok {
			count += freq
		}
		m[rSum] += 1
	}

	return count
}
