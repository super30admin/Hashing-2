class Solution {
    public int longestPalindrome(String s) {

        int len =0;
        Set<Character> map = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(map.contains(s.charAt(i))){
                len+=2;
                map.remove(s.charAt(i));
                
            }else{
                map.add(s.charAt(i));
            }
        }

        if(map.size()>0){
            len+=1;
        }

        return len;
    }
}
