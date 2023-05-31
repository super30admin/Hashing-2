/* Time complexity O(n) 
Space complexity o(1) */


class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            char p=s.charAt(i);
            if(set.contains(p)){
                count+=2;
                set.remove(p);
            }
            else{
                set.add(p);
            }

        }
        if(!set.isEmpty()){
            count++;
        }
        return count;
    }
}