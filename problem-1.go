/*time complexity : O(n)
space complexity : O(n)*/

func subarraySum(nums []int, k int) int {
	if(len(nums) == 0){
		return 0
	}
	m := make(map[int]int)
	m[0] = 1
	runningSum := 0
	count:= 0
	for i:=0;i<len(nums);i++{
		runningSum += nums[i]
		val_x, ok := m[runningSum-k]
		if ok {
			count += val_x
		}
		if _, ok = m[runningSum]; ok {
			m[runningSum] += 1
		} else{
			m[runningSum] = 1
		}
	}
	return count
}
