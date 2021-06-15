// Time Complexity : O(N)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this: understood
// Summary: create hashset and add value if not in there and remove value if there while adding 2 to the counter
//	    then if hashset is empty then no leftover elements left to add to counter, if it not empty add 1 to count

class Solution {
    public int longestPalindrome(String s) {
        if(s ==null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
            }else{
                count += 2;
                set.remove(c);
            }   
        }
        if(!set.isEmpty()){
            count += 1;
        }        
        return count;
        
    }
}