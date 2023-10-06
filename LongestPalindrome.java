// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> set=new HashSet<>();
        int count=0;
        if(s==null ||s.length()==0)return 0;
        if(s.length()==1)return 1;
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
            }else{
                set.remove(s.charAt(i));
                count+=2;
            }
            
        }
        if(!set.isEmpty()){
                count+=1;
            }
        return count;
    }
}