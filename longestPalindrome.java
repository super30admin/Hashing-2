// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
import java.util.HashSet;

class longestPalindrome {
         public int longestPalindrome(String s) {
        if(s==null || s.length() ==0){
            return 0;
        }
        HashSet<Character> set=new HashSet<>();
        int count=0;

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(set.contains(c)){
                set.remove(c);
                count=count+2;
            }
            else{
                set.add(c);
            }
        }
        if(!set.isEmpty()){
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
    longestPalindrome rs = new longestPalindrome();
    System.out.println(rs.longestPalindrome("abccccdd"));  // ans = 7
    System.out.println(rs.longestPalindrome("a"));  // ans = 1
}

}