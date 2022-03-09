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