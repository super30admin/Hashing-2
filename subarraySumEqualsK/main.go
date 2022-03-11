package main

import "fmt"

/*
560. Subarray Sum Equals K
Medium

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2
*/

func subarraySum(nums []int, k int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}
	runningSum := 0
	count := 0
	state := map[int]int{0: 1}
	for i := 0; i < len(nums); i++ {
		runningSum += nums[i]
		diff := runningSum - k
		if times, ok := state[diff]; ok {
			count += times
		}
		state[runningSum]++
	}
	return count
}

func main() {
	fmt.Println(subarraySum([]int{1, 2, 3}, 3))
}
