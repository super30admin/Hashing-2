// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> hashSet=new HashSet<>();
        
        int size=0;
        
        for(int x = 0; x < s.length(); x++){
            char ch=s.charAt(x);
            
            if(hashSet.contains(ch)){
                size+=2;
                hashSet.remove(ch);
            }else{
                hashSet.add(ch);
            }
        }
        
        if(!hashSet.isEmpty()){
            size+=1;
        }
        return size;
    }
}
