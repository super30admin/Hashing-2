//Longest Palindrome with given letters
// Time Complexity: O(n)
//Space Complexity: O(n)

// using map to store the even number of elements and add a flag to store odd nunber elements


class Solution {
    public int longestPalindrome(String s) {

        HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>();

        for(char c : s.toCharArray()){
            if(!freqMap.containsKey(c)){
               freqMap.put(c, 1);
            } else {
                 freqMap.put(c, freqMap.get(c)+1);
            }
        
        }
        int count = 0;
        boolean flag = false;

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            if (freq % 2 == 0) {
                count += freq;
            } else {
                count += freq - 1;   // if freq = 5, adds 4
                flag = true;
            
             }
        }

             if(flag){
                return count +1;
             } 
             return count;
        
    }
}