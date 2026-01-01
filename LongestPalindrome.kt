//TimeComplexity O(n)
//SpaceComplexity O(1) 52 charackters at the max(26 for smallcase letters and 26 for uppercase letters). 
// In this problem we need provide length of longest palindrome possible. we store the characters in a hashset, 
// we add an element when we come across it first time and then pop or remove it when we come across same charater again. 
// When returning the count we check if there is an element left in the hashset, if true then we add 1 to the count and return the count.  

class Solution {
    fun longestPalindrome(s: String): Int {
        val set = HashSet<Char>();
        var count = 0;

        for(i in 0..s.lastIndex) {
            if(set.contains(s[i])) {
                set.remove(s[i])
                count += 2
            } else {
                set.add(s[i])
            }
        }
        if(!set.isEmpty()) {
            count++
        }
        return count;
    }
}