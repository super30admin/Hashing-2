/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxLength = function(nums) {
    let container = new Map();
    let maxSub = 0;
    let count = 0;
    container.set(0,-1)

    for(let i=0;i<nums.length;i++) {
    
        count = count + (nums[i] === 1 ?  1 : -1);
        if(container.has(count)) {
            
            // calculate subarray by getting the previous occurence
            let prevIndex = container.get(count);
            let newSum = i - prevIndex;
            maxSub = Math.max(newSum, maxSub);
        } else {
            container.set(count, i);
        }
    }
    return maxSub;
};