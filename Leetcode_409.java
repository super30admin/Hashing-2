//Rule: Lookslike a mirror immage. i.e., replica. So, we should have same characters at both front side and back side. So, there should be one char with odd times and rest all should be even times.
//Solving it using set
//TC: O(n); SC:O(n)
class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set=new HashSet<>();

        int ans=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(set.contains(ch)){
                set.remove(ch);
                ans+=2;
            }else{
                set.add(ch);
            }

        }

        if(set.size()>0) ans+=1;

        return ans;
        
    }
}
