// ## Problem3 (https://leetcode.com/problems/longest-palindrome)
//Did this code run on Leetcode : YES
//Did you face any problems : Was finding it hard how to handle the odd case
var longestPalindrome = function(s) {
    //Time Complexity = O(N)
    //Space Complexity = O(1)
    //Because the constraints of the problem say s consists of lowercase and/or uppercase English letters only.
    //That means we have a hashMap of characters not less than 26+26 characters
    let hashMap = new Map()
    let count = 0
    let hasODD = false
    // Make a freq counter 
    for(let i =0;i<s.length;i++){
        hashMap.set(s[i],(hashMap.get(s[i])||0)+1)
    }
    //Map over the hashMap
    for(let [key,value] of hashMap){
        //take the values if even
        if(value%2==0) count+=value
        else {
            count+=value-1
            hasODD = true
        }
    }
    //make up for not taken all odds
    if(hasODD) count+=1
    return count
};