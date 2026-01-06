/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 * 
 * Intution:
 * I am using prefix sum plus hashMap approach in here.
 * At each index i am calculating the currSum and check if the diff between the k and currSum exists before in the array. If yes, i am incrementing the count by the value length.
 * And if the currSum is in the map then adding the new index to the array, otherwise creating the array with the currIndex.
 * Time Complexity: O(n);
 * Space Complexity: O(n)
 */
var subarraySum = function (nums, k) {
    let preFixMap = new Map();
    let currSum = 0;
    // set 0 with -1 to handle the edge case
    preFixMap.set(0, [-1]);
    let count = 0;
    for (let i = 0; i < nums.length; i++) {
        currSum += nums[i];
        const diff = currSum - k;
        if (preFixMap.has(diff)) {
            const currAssignedVal = preFixMap.get(diff);
            count += currAssignedVal.length;
        }
        if (preFixMap.has(currSum)) {
            const currArr = preFixMap.get(currSum);
            currArr.push(i);
        } else {
            preFixMap.set(currSum, [i]);
        }
    }
    return count;
};