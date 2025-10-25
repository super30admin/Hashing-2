class Solution {
    public int longestPalindrome(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int result = 0;
        boolean odd_val_exists = false;
        
        for(int c: map.values()){

            if(c%2==0){
                result = result + c;
            }

            else{
                odd_val_exists = true;
                result = result + (c-1);
            }

        }

        if(odd_val_exists){
            result++;
        }

        return result;

       
       
        
    }
}