// Time Complexity : O(n) where n is length of string s
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

/**
 * @param {string} s
 * @return {number}
 */
 var longestPalindrome = function(s) {
    const set = new Set();
    let count = 0;
    for (let i=0; i<s.length; i++) {
        const char = s[i];
        if(set.has(char)) {
            count += 2;
            set.delete(char);
        } else {
            set.add(char);
        }
    }
    if(set.size !== 0) count++;
    return count;
};