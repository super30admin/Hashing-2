// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Result(length of longest palindrome) is incremented by 2 whenever we come across a pair
// To keep track of pairs we use a hashset to store single elements
// Once we get a pair we can update result and remove from hashset


class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int result = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(set.contains(ch)) //true=> we found a pair
                {
                    result = result + 2;
                    set.remove(ch); 
                }
            else
                set.add(ch);
        }
        if(!set.isEmpty()) //to account for middle element need not having to be a pair
            result++;
        return result;
    }
}