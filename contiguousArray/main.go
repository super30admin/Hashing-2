/*
    approach: running sum
    - We will use running sum / count principle
    - Since we need the longest subarray, we will use a map to store {$rs:$idxSeenAt}
    - running sum / count will be incremented by 1 if ith val == 1 
    - running sum / count will be decremented by 1 if ith val == 0
    - If we run into a running sum at an ith position that we have seen before ( lookup new rs in map )
    - Than that means from that idx from map lookup+1 till current ith idx - we have a balanced subarray
    - Calc this window size ( right-left+1 ) -- i-(idxFromMap+1)+1
    - Then save the above window size to max as needed.
    
    Why start our idxMap with {0:-1} ?
    - because we could have a case at the beginning where running sum becomes 0
    - but we have not had added a 0 yet in our hashmap, AND if we reached a 0 without having any initial 0 in idx map, this is a balanced subarray right
    - therefore we need to start our idx map with {0:-1}
    Example: [1,1,1,0,0,0]
    { 1:0,2:1,3:2, 2:3, 1:4, 0:5 }
    - notice how our hashmap does not have the initial 0:-1
    - we will have an answer but that wont be the longest subarray ( rSum 1 is repeating )
    - however we miss the fact that the rSum ended with 0 and because we never had a 0 to compare with, we never assume that as a potential answer.
    - Therefore we need to start our hashmap with {0:-1}
    
    To find the longest length , we will maintain indicies ( not override existing keys because we want the longest )
    if we were asked to find the count number of subarrays, then idxMap becomes freqMap
    
    Time: o(n)
    Space: o(1)
*/
func findMaxLength(nums []int) int {
    count := 0
    max := 0
    countIdx := map[int]int{0:-1}
    for i := 0; i < len(nums); i++ {
        if nums[i] == 0{count--}
        if nums[i] == 1{count++}
        idx, seen := countIdx[count]
        idx++
        if !seen {
            countIdx[count] = i
        } else {
            // current subarray size
            cl := i-idx+1
            if cl > max {
                max = cl
            }
        }
    }
    return max
}