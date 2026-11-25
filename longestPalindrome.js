/**
 * @param {string} s
 * @return {number}
 */
var longestPalindrome = function(s) {
    /**
    consider even letters - and take one odd letter
    
     */
     let container = new Map();
     let longestPali = 0;
     for(let i=0;i<s.length;i++) {
        if(container.has(s[i])) {
            container.delete(s[i]);
            longestPali+=2;
        } else {
            container.set(s[i],1);
        }
     }
     if(container.size > 0) {
        return ++longestPali;
     } else {
        return longestPali;
     }
};