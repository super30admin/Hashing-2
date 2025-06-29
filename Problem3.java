class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character>set = new HashSet<>();
        int l=0;
        for(char c:s.toCharArray()){
            if(set.contains(c)){
               l +=2;
               set.remove(c);
            }
            else{
                set.add(c);
            }
        }
    
    if(!(set.isEmpty())){
        l+=1;
    }
 return l;
    }
}
