package main

import "fmt"

/*
525. Contiguous Array
Medium

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.



Example 1:
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

Example 2:
Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.



Note: we need max length -- so likely going to have to save some idx positions to be compared later


Brute force:
With nested iterations, we can count numOnes and numTwos
if at any point numOnes == numTwos - then get the current len (j-i)
if the currentLen > maxLen then save the currentLen and keep checking
all other subarrays.
Time: o(n^2)
Space: o(1)



This can be optimized by keeping a runningSum
*/

func findMaxLength(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}

	runningSum := 0
	maxLen := 0
	state := map[int]int{0: -1}
	for i := 0; i < len(nums); i++ {
		if nums[i] == 1 {
			runningSum++
		} else {
			runningSum--
		}

		idx, seen := state[runningSum]
		if seen {
			if i-idx > maxLen {
				maxLen = i - idx
			}
		} else {
			state[runningSum] = i // saving idx because we need len and not count
		}
	}

	return maxLen
}

func main() {
	fmt.Println(findMaxLength([]int{0, 1, 0}))
}
