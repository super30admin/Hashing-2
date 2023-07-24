class Solution {
    //Time Complexity :- O(n)
    //Space COmplexity :- O(1)
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count =0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                set.remove(c);
                count+=2;
            }else{
                set.add(c);
            }
        }
        if(!set.isEmpty()) count++;
        return count;
    }
}