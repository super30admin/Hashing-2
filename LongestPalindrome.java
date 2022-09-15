// Time complexity : O(n)
// Space Complexity: O(1) because we valid ascii characters
// submission successful on leetcode
class Solution {
    public int longestPalindrome(String s) {
        
        if(s==null || s.length()== 0) return 0;
        
        HashSet<Character> set = new HashSet<>();
        int len=0;
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(set.contains(c)){
                len=len+2;
                set.remove(c);
            }
            else{
                set.add(c);
            }
        }
        
        if(set.size() >0){
            len++;
        }
        return len;
    }
}