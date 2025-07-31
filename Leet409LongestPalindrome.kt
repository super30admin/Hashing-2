// Time Complexity :O(n) scanning all
// Space Complexity :0(1) only 26 chars
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
//line 36 and line 29 'A'.code
class Solution {
    fun longestPalindrome(s: String): Int {
        //a palindrom would be even freq of chars + 1 for odd
        var count = 0
        val set = HashSet<Int>()
        for(c in s){
            if(set.contains(c.code)){
                count += 2
                set.remove(c.code)
                continue
            }
            set.add(c.code)
        }
        return if(set.isEmpty())count else count + 1
    }
}

class Solution {
    fun longestPalindrome(s: String): Int {
        //a palindrom would be even freq of chars + 1 for odd
        var count = 0
        val arr = IntArray(65)
        for(c in s){
            if(arr[c.code - 'A'.code] > 0){
                count+=2
                arr[c.code - 'A'.code]--
                continue
            }
            arr[c.code - 'A'.code]++
        }
        return if(s.length > count) count + 1 else count
    }
}