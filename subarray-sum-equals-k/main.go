package main

/*

Initial Thought Process
- Create Sub arrays and then loop over then to see if sum of a given sub array is equal to target.
- The TC for above would be : Creation of Sub arrays i.e. O(N^2) + Checking for sum i.e. O(N)

Since I am given an array, I have the following things handy
- Index when I am in a for loop
- Sum of all elements when I am present at a given index (also called the running sum)
- If I am storing the sum/runningSum in a DS, then I can do some maths and calculate the sum between two indices OR I can substract a number and see if the result has happened in the paast
- This is what essentially becomes the answer to this question


Pattern is called Running Sum Pattern

*/

// Time : O(N) - since we are looping over the entire array
// Space : ~O(1)
func subarraySum(nums []int, k int) int {

	// counter for number of subarrays that are equal to given target k
	count := 0
	sum := 0
	// map to store sum at a given index
	// make a default entry
	sumAtIndex := map[int]int{0: 1}

	for i := 0; i < len(nums); i++ {
		sum += nums[i]
		// y = x - z
		subArraySum := sum - k
		// check in map
		val, present := sumAtIndex[subArraySum]
		if present {
			count += val
			// add sum to map
			sumAtIndex[sum]++
		} else {
			// if not present; then add to map
			// key is sum : value is index at which it was seen
			// can be made to look clean by removing the else condition and moving #40 out of if ; but going to leave this like this
			// for now to get hold of the though process
			val, present = sumAtIndex[sum]
			if present {
				sumAtIndex[sum] = val + 1
			} else {
				sumAtIndex[sum] = 1
			}
		}
	}
	return count

}
