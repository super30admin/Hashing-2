//Accepted in Lt
// Stored all count of each letter in hashmap and than based on even and odd found the largest palindrome


class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int odd = 0;
        int length = 0;
        char[] charArray = s.toCharArray();
        for(char c : charArray){
            if(hm.containsKey(c)){
                hm.put(c,hm.get(c)+1);
            }
            else{
                hm.put(c,1);
            }
        }
        for(Integer v : hm.values()){
            int n = v % 2;
            if(n==0){
                length = length + v;
            }
            else{
                if(n>0){
                    v=v-1;
                    length = length + v;
                }
                if(odd==0){
                    odd=1;
                }
            }

        }
        if(odd==1){
            length = length + 1;
        } 
        return length;

    }
}