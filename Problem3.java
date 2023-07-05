// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// To find the longest palendrom sting with the given string (not contiguous), hash set is used when the same element is found in the hash set, count is incremented to 2 and removed from set
//if the set is not emapty at the end, count is incremented by one and return the count

class Solution {
    public int longestPalindrome(String s) {
        //Time Complexity: O(n)
        //Space Complexity: O(n)
        HashSet<Character> set = new HashSet<>();
        int count=0;
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(set.contains(c)){
                count +=2;
                set.remove(c);
            }else{
                set.add(c);
            }
        }
           if(!set.isEmpty()){
                count +=1;
            }
        return count;
    }
}