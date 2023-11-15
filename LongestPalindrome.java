//Time Complexity:O(n)
//Space Complexity:O(1)
class Solution {
    public int longestPalindrome(String s) {
        if(s==null) return 0;
        if(s.length()==1) return 1;
        int count = 0;
        HashSet<Character> charSet = new HashSet<>();

        for(char c: s.toCharArray()){
            if(charSet.contains(c)){
                count+= 2;
                charSet.remove(c);}
            else
                charSet.add(c);
        }

        if(!charSet.isEmpty()) count++;
        return count;

    }
}