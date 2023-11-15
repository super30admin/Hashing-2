// Problem2 (https://leetcode.com/problems/contiguous-array/)
// tc is O(n) and sc is O(n)
//Yes accepted in leet code

/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxLength = function(nums) {

    let m = new Map();
    let max =0;
    let sum =0;
    m.set(0,-1);
    for (let i=0; i<nums.length; i++){

        if(nums[i] === 0){
            sum--;
        }
        else sum++;

        if(m.has(sum)){
            max= Math.max(max, i-m.get(sum));
        }
        else{
            m.set(sum,i);
        }

    }

    return max;    
};