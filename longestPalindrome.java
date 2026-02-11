// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
I would take a map to store the occurences of the characters in given string. Now, if we know there
are even occurences, they tend to reflect same in reverse as well. So I directly increment my count
variable with that value. If odd occurences, I would need only even portion of it for the output to
be same in reverse order. So, I increment my count with those occurences - 1. I also keep track of
odd occurence existence using a flag. While final return of count, check if flag reflects odd occurence presence, if so, return extra one to the count as it would not change the palindrome and
max value is asked.
*/

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        boolean flag = false;
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(int i : map.values()) {
            if(i%2 == 0)
                count += i;
            else {
                count += i - 1;
                flag = true;
            }
        }
        return flag == true ? count + 1 : count;
    }
}
