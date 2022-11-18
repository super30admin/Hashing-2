// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxLength = function(nums) {
  if (nums.length === 0 || nums === null) {
    return -1;
  }

  var rSum = 0;
  var max = 0;
  var hMap = new Map();
  // Handle where first element is 0
  hMap.set(0, -1);
  for (var i = 0; i < nums.length; i++) {
    var n = Number(nums[i]);
    if (n === 0) {
      rSum -= 1;
    } else {
      rSum += 1;
    }
    if (hMap.has(rSum)) {
      var val = hMap.get(rSum);
      var newMax = i - val;
      if (newMax > max) {
        max = newMax;
      }
    } else {
      hMap.set(rSum, i);
    }
  }
  return max;
};
