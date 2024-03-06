import java.util.HashSet;

class Solution {
    /* Time Complexity :O(n);
       Space Complexity: O(1);
    
       Executed in leetcode;
     */
        public int longestPalindrome(String s) {
            int count = 0;
            HashSet<Character> set = new HashSet<>();
    
            for (int i = 0; i< s.length(); i++){
                char sChar = s.charAt(i);
                if(set.contains(sChar)){
                    count += 2;
                    set.remove(sChar);
                }else{
                    set.add(sChar);
                }
    
            }
            if (!set.isEmpty()){
                    count++;
            }
            return count;
    
    
    
            
        }
    }