// Time Complexity : O(n) -> n: length of string
// Space Complexity : O(n) -> n: length of string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/* Approach:
   WHile traversing the string, keep adding the element to the set, if it doesnt exist. 
   If it already exists increase count by 2 and remove it from the set. This way we are finding pairs
   At the end, check if the set still has anything, if yes increment count by 1 
   As this will be the 1 char which can come in the center of palindrome.
*/

class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> track = new HashSet<>();
        int count = 0;
        for(int i=0;i<s.length(); i++){
            if(track.contains(s.charAt(i))){
                count+=2;
                track.remove(s.charAt(i));
            }else{
                track.add(s.charAt(i));
            }
        }
        if(!track.isEmpty()){
            count++;
        }
    return count;
    }
}