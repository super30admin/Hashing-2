// Time Complexity :o(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// approach: use hashset to store the characters if the character already exits then increase the count by 2 and delete the element if not add. at the end if there are any elements present in the hash set then add count by 1
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set=new HashSet();
        int count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(set.contains(c)){
                count+=2;
                set.remove(c);
            }else{
                set.add(c);
            }
            
        }
        if(!set.isEmpty()){
                count++;
            }
        return count;
        
    }
}