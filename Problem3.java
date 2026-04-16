// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count = 0;
        boolean hasOdd= false;
        for(int i:map.values()){
            if(i%2==0){
                count= count+i;
            }else {
                count = count+(i-1);
                hasOdd= true;
            }
        }
        if (hasOdd){
            count=count +1;
        }
        return count;

    }
}

// Used Hashmap to create a frequency map of the characters, 
// then I checked if the frequency is even or odd, 
// if it is even then I can use all of them to create a palindrome, 
// if it is odd then I can use (frequency-1) to create a palindrome 
// and I can use one odd character in the middle of the palindrome.