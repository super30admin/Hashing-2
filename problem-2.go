/*time complexity : O(n)
space complexity : O(n)*/

/*func main() {
	nums := []int{0, 1, 1}
	fmt.Println("Length of nums: ", len(nums))
	longest := findMaxLength(nums)
	fmt.Println(longest)
}*/

func findMaxLength(nums []int) int {
	m := make(map[int]int)
	m[0] = -1
	maxRunningSum := 0
	runningSum := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 {
			runningSum--
		} else {
			runningSum++
		}
		val, ok := m[runningSum]
		if ok {
			length := i - val
			if length > maxRunningSum {
				maxRunningSum = length
			}
		} else {
			m[runningSum] = i
		}

	}
	return maxRunningSum
}
