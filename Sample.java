// Time Complexity :O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Throwing Null Pointer Exception at line number 15
// Any problem you faced while coding this : Finding out the algorithm to approach this problem


// Your code here along with comments explaining your approach
class Solution {
    //Loading each letter in the string to hashmap with the number of occurence of the letter as value
    public int longestPalindrome(String str) {
            Map<Character, Integer> map = new HashMap<>();
            for(int i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                if(map.containsKey(ch))
                    map.put(ch, map.get(i) + 1);
                else
                    map.put(ch, 1);
            }
            //Trying to find if the letters has occured even or odd number of times based on which they are added to the length variable
            boolean oddelements = false;
            int len = 0;
            for(int count : map.values()){
                if(count % 2 == 0)
                    len += count;
                else{
                    oddelements = true;
                    len += count - 1;
                }
            }
            // If even the length is printed out as it is else the length is incremented by one (because we need a center letter in case of a string whose length is odd)
            if(!oddelements)
                return len;
            else
                return len + 1; 
        
        }
}