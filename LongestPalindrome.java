// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Time complexity - O(n)
//Space complexity - O(1)

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
int count=0;
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
            }
            else{
                set.remove(s.charAt(i));
                count=count+2;
            }
        }
        if(!set.isEmpty())count++;
        return count;
    }
}