// Time Complexity : O(n), iterating over the string of length n
// Space Complexity : O(1) because at max there can be only 26 characters in the map
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for(char c : s.toCharArray()){
            if(set.contains(c)){ //if a pair of char is found increase the counter by 2
                count += 2;
                set.remove(c); // remove that character
            }
            else{
                set.add(c);
            }
        }

        if(!set.isEmpty()) // we can have one unique character as the middle of palindrome
        {
            count++;
        }

        return count;
    }
}