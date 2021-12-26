// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach


class LongestPalindrome {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0; 
        HashSet<Character> set = new HashSet<>();
        int count = 0 ; 
        for(int i =0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                count = count + 2; 
                set.remove(c);
            }else{
                set.add(c);
            }
            
        }
        if(!set.isEmpty()){
            count ++;
        }
        return count;
    }
}