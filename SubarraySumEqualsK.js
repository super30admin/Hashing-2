// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraySum = function(nums, k) {
  if (nums.length === 0 || nums === null) {
    return -1;
  }

  var rSum = 0;
  var count = 0;
  var hMap = new Map();
  var rSum = 0;

  hMap.set(0, 1);

  for (var i = 0; i < nums.length; i++) {
    var n = Number(nums[i]);
    rSum = rSum + n;
    var y = rSum - k;
    if (hMap.has(y)) {
      count = count + Number(hMap.get(y));
    }

    if (hMap.has(rSum)) {
      var prevVal = hMap.get(rSum);
      hMap.set(rSum, prevVal + 1);
    } else {
      hMap.set(rSum, 1);
    }
  }
  return count;
};
