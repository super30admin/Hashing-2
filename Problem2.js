// ## Problem2 (https://leetcode.com/problems/contiguous-array/)
//Did this code run on Leetcode : YES
//Did you face any problems : Had to understand the running sum PATTERN, was stuck on trying to make a sliding window sol

var findMaxLength = function(nums) {
        //Time Complexity = O(N)
    //Space Complexity = O(N)
    let maxLength = 0
    let runningSum = 0
    let hashMap = new Map()
    //Handle Base case to set first balanced subArray to true
    hashMap.set(0,-1)
    for(let i =0;i<nums.length;i++){
        //Set running sum add -1 if its 0 or add +1 if its 1
        runningSum += nums[i]==0?-1:1
        //Check if the current runningSum is in the map
        if(hashMap.has(runningSum)){
            //Subtrack the existing index from the one seen before 
            //!2 same running sum have a balanced sumArray
            maxLength = Math.max(maxLength,i-hashMap.get(runningSum))
        }
        //if not store it
        else{
            hashMap.set(runningSum,i)
        }
        
    }
    return maxLength
};