// Time Complexity : O(n) - Traversing the string once
// Space Complexity : O(1) - Using hashset within affordable range i.e max num of alphabets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * @param {string} s
 * @return {number}
 */
var longestPalindrome = function(s) {
  if (s.length === 0 || s === null) {
    return -1;
  }

  var mySet = new Set();
  var count = 0;

  for (var i = 0; i <= s.length - 1; i++) {
    if (mySet.has(s[i])) {
      // Increase the counter to 2 as the character is getting repeated
      count += 2;
      mySet.delete(s[i]);
    } else {
      mySet.add(s[i]);
    }
  }
  if (mySet.size > 0) {
    count += 1;
  }
  return count;
};
