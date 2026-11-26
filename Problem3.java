// Time Complexity : O(N)
// Space Complexity : O(1) because at most we will have 52 characters.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Approach: We create a Set and while iterating we check if set contains the char
// If yes we remove the char from the set and increment our counter to 2 (since that would be a occurance)
// if at the end our set is not empty that means we have some values which does not have occurance
// we can incerement our counter to 1 since we can take any once char

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int counter = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                counter=counter+2;
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        if(!set.isEmpty()){
            counter=counter+1;
        }
        return counter;
    }
}