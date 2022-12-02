// Time Complexity : O(s) 
// Space Complexity : O(s)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

We need to pick the characters , and can pick them only the number of times they have appeared on the string
We need to pick the maximum chars to form a palindrome
A palindrome is a string that read backwards is the same
*/
class Solution {
    public int longestPalindrome(String s) {

        // we will store the characters seen in the hashset, and remove them as we see them again in the set and increase the count by 2 each time

        HashSet<Character> set = new HashSet<Character>();

        int count =0;
        // we will go through the string

        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(set.contains(c)){
                // increment count by 2
                count+=2;
                //remove from set
                set.remove(c);
            }
            else{
                set.add(c);
            }
        }
    // if some characters left in the set, then we can take only one of them , so we will increase the count by one
    if(set.size() >0){
        count+=1;
    }

    return count;

    }
}