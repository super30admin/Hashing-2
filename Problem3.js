// Problem3 (https://leetcode.com/problems/longest-palindrome)

//tc O(n) is and sc is O(1)  
//Yes accepted in leet code


/**
 * @param {string} s
 * @return {number}
 */
var longestPalindrome = function(s) {


    let p = new Set();
    let count =0;

    let str = s.split('');

    for(let i=0;i<str.length;i++){
        if(p.has(str[i])){
            count+=2;
        p.delete(str[i]);

        }
        else{
            p.add(str[i]);
        }
    }

    if(p.size !== 0) count++;

    return count;
    
};