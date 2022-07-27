// Time Complexity : O(n) where n is the number of char present in the string
// Space Complexity : O(n) where n is the number of unique char present in the string at the worst case
// Did this code successfully run on LeetCode : yes
// Any problem you faced while coding this : no

class Solution {
    fun longestPalindrome(s: String): Int {

        val hashSet = hashSetOf<Char>()

        var longPalindrome = 0

        for(char: Char in s){

            if(hashSet.contains(char)){
                hashSet.remove(char)
                longPalindrome += 2
            }else{
                hashSet.add(char)
            }
        }

        if(hashSet.size != 0){
            return longPalindrome +1
        }

        return longPalindrome

    }
}