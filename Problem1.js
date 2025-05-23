// ## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
//Did this code run on Leetcode : YES
//Did you face any problems : Had to understand the math behind the logic X+Y = Z 

var subarraySum = function(nums, k) {
    //Time Complexity = O(N)
    //Space Complexity = O(N)
    let count = 0
    let runningSum = 0
    let hashMap = new Map()
    //Set we say 0 once to handle the base case
    hashMap.set(0,1)
    for(let i =0;i<nums.length;i++){
        //Find running Sum
        runningSum += nums[i];
        //Check if we saw the running sum and the diff before 
        if(hashMap.has(runningSum-k)){
            //if we did that means there was a subarray with sum target
            //increment out count
            count += hashMap.get(runningSum-k)
        }
        //update out running sum occerence
        hashMap.set(runningSum, (hashMap.get(runningSum)||0) +1)
    }
    return count
};