class Solution {
    public int longestPalindrome(String s) {

       boolean[] set = new boolean[95];  
       int count = 0;

       for(char c: s.toCharArray()){
            if(set[c - 'A']){
                count += 2;
                set[c - 'A'] = false;
            }else{
                set[c - 'A'] = true;
            }
       }

       if(s.length() == count) return count;
       return count+1;
    }
}

Time Complexity : O(n)
Space Complexity : O(1)