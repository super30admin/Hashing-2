/**
 * @param {number[]} nums
 * @return {number}
Intution: 
I use a prefix sum approach with a hash map to track the difference between the number of 1s and 0s seen so far.
I treat each 1 as +1 and each 0 as -1.
To handle subarrays that start at index 0, I initialize the running count to 1 and store this count at index -1 in the hash map. 

As I iterate through the array, I update the running count based on the current value.
If the same count has been seen before, it means the subarray between the previous index and the current index has an equal number of 0s and 1s. I compute the length of this subarray and update the maximum length.

I only store the first occurrence of each count in the hash map to make sure the longest possible subarray is captured.

Finally, I return the maximum length found.
 */

var findMaxLength = function (nums) {
    let hashMap = new Map();
    hashMap.set(1, -1);
    let currCount = 1;
    let maxLength = 0;
    for (let idx = 0; idx < nums.length; idx++) {
        currCount += nums[idx] === 0 ? -1 : 1;
        if (hashMap.has(currCount)) {
            maxLength = Math.max(maxLength, idx - hashMap.get(currCount));
        } else {
            hashMap.set(currCount, idx);
        }
    }

    return maxLength;
};