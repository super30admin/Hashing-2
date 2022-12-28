// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int longestPalindrome(String s) {
        //Boy, this looks a little tricky. 
        //We create a frequency map for letters of the string. 

        HashMap<Character, Integer> freq = new HashMap<>();

        for(int i = 0; i < s.length(); i++){

            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);

        }

        //We need atmost one character that is unique. 

        
        int count = 0;
        //Variable for keeping track if the single character is found. 
        boolean single_odd = false;

        for(Map.Entry<Character, Integer> entry : freq.entrySet()){

            int letter_count = entry.getValue();
            if(letter_count == 1){
                if(!single_odd){
                    single_odd = true;
                    count ++;
                }
            }

            //if the frequency is odd then take the nearest even

            else{
                if(letter_count % 2 != 0){

                    //We can include one of the odd letters as a single odd. 
                    if(!single_odd){
                        count += letter_count;
                        single_odd = true;
                    }

                    else{
                        count = count + (letter_count - 1);
                    }
                    
                }

                else{
                    count += letter_count;
                }
            }

        }

        return count;

    }
}