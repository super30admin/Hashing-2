// Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)

// tc is O(n) and Sc id O(n)
// yes accepted in Leetcode


/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraySum = function(nums, k) {

    let m = new Map();
    count = 0;
    rsum=0
    m.set(0,1); //dummy entry to catch the first subarray

    for (let i =0;i<nums.length;i++)
    {
        rsum= rsum+nums[i];

        if(m.has(rsum-k)){

            count = count+m.get(rsum-k)
        }
        m.set(rsum, (m.get(rsum) || 0) +1)
    
    
    }

    return count;
    
};