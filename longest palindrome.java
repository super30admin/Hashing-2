// TimeComplexity: O(n)
// SpaceComplexity: O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count =0;
        for(int i=0; i<s.length(); i++) {
            char ch =  s.charAt(i);
            if(set.contains(ch)){
                count =count+2;
                set.remove(ch);
            } else{
                set.add(ch);
            }
        }
        if(!set.isEmpty()){
            count=count+1;
        }
        return count;
    }
}
