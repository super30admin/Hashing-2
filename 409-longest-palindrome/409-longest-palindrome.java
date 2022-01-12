class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
                count += 2;
                
            }
            else{
                set.add(s.charAt(i));
            }
        }
        if(!set.isEmpty()){
            count+=1;
        }
        return count;
    }
}