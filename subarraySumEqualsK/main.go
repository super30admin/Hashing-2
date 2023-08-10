// time = o(n)
// space = o(1)
func subarraySum(nums []int, k int) int {
    runningSum := 0
    freq := map[int]int{0:1}
    count := 0
    for i := 0; i < len(nums); i++ {
        runningSum += nums[i]
        /*
            what will make this runningSum equal to k ?
            
            runningSum = 13
            k = 3            
            we need to add -10 to make runningSum == k
    
            runningSum = 3
            k = 7
            we need to add 4 to make runningSum == k
            
            to make runningSum = k
            we need to remove runningSum-k from runningSum
            if we have this diff (y), it means
            up to this idx, runningSum is x
            up to some old idx, runningSum is y
            and if we remove y from x, we get k
        */
        
        diff := runningSum-k
        val, ok := freq[diff]
        if ok {
            count += val
        }
        freq[runningSum]++
    }
    return count
}
