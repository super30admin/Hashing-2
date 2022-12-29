package main

import "fmt"

// Todo : Drop some thinking process?

// Time : O(N) : n is the number of elements in nums array
// Space : O(1)

func findMaxLength(nums []int) int {
	sum := 0
	maxLengthOfSubArray := 0
	sumAtIndex := map[int]int{0: -1}
	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 {
			sum = sum - 1
		} else {
			sum = sum + 1
		}
		//sum += nums[i]
		atOldIndex, present := sumAtIndex[sum]
		if !present {
			// sum = index - basically at which index has the sum happened
			sumAtIndex[sum] = i
		} else {
			//current index - old index = length of sub array
			if (i - atOldIndex) > maxLengthOfSubArray {
				maxLengthOfSubArray = i - atOldIndex
			}
		}

	}
	fmt.Println(sumAtIndex)
	return maxLengthOfSubArray
}
