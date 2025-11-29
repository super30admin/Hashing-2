/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxLength = function(nums) {
    let currSum = 0
    let prefixSumMap = new Map()
    let longestSubArray = 0
    prefixSumMap.set(0,-1) // since we assume 0 as starting sum which is at index -1 

    for (let i = 0; i<nums.length; i++){
        /*
        if we see a 0 we subtract 1 
        if we see a 1 we add 1 
        by doing this way the total sum remains unchanged 
        */
        if (nums[i] === 0){
            currSum -= 1 
        }
        else {
            currSum += 1 
        }
        if (prefixSumMap.has(currSum)){
            longestSubArray = Math.max(longestSubArray, i-prefixSumMap.get(currSum))
        }
        else{
            prefixSumMap.set(currSum,i)
        }

    }
    return longestSubArray
    
};