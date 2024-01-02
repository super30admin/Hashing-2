import java.util.HashSet;
//TC:- On
//SC:-O(1)
class Solution {
    public int longestPalindrome(String s) {
        int count=0;
        HashSet hs=new HashSet();
        for(int i=0;i<s.length();i++){
            char schar=s.charAt(i);
            if(hs.contains(schar)){
                count=count+2;
                hs.remove(schar);
            }
            else{
                hs.add(schar);
            }


        }
        if(!hs.isEmpty()){
            return count+1;
        }
        return count;
    }
}