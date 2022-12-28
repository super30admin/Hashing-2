/*
    approach: brute force
    - using nested for loop, form every single subarray and check its sum
    - if sum == target, count++
    
    time: o(n^2)
    space: o(1)
    
    
    approach: running sum + complement search
    - to do complement search, we need some lookup data structure
        - map would be a good fit for this
    - We will have a running sum as we are looping over the nums array
    - at each runningSum, we will search for a number that will be needed to add to this runningSum to make it == target
    - in other words, complement search
    - what number do I need to add to this runningSum to make it == target
    - target-runningSum - will give you the complement number 
    - search for this complement in our map, if found, take its value and add to count
    - if not found, then save this runningSum and increment its count by 1 in the map
*/
func subarraySum(nums []int, k int) int {
    freqMap := map[int]int{0:1}
    count := 0
    // if we have an x ( running sum ) and we have a y ( running sum )
    // then do get a value of z ( running sum ) ; z is a subarray between y and x
    // then we find z; z = x-y
    // but here we are given k and we have a running sum x
    // z is our k
    // z = x - y 
    // and we have to find whether we have seen a y before given x and z(k)
    // y = x-z
    // if we have seen that y before ( search all running sum therefore hashmap )
    // then that means sum of all elements from y is k
    rSum := 0
    for i := 0; i < len(nums); i++ {
        rSum += nums[i]
        y := rSum-k
        c, ok := freqMap[y]
        if ok {
            count += c
        }
        freqMap[rSum]++
    }
    
    
    return count
}