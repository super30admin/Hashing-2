class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set=new HashSet<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(set.contains(ch)){
                count+=2;
                set.remove(ch);
            }
            else set.add(ch);
        }
        if(!set.isEmpty()) count++;
        return count;
    }
}