/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraySum = function(nums, k) {
    let container = new Map();
    let currentSum = 0;
    let totalSubArr = 0;

    container.set(0,1);

    for(let i=0;i<nums.length;i++) {
        currentSum += nums[i];
        let reqSum = currentSum-k;
        if(container.has(reqSum)) {
            totalSubArr += container.get(reqSum);
        } 
            container.set(currentSum,((container.get(currentSum) || 0) + 1))
        
    }
    return totalSubArr;
};