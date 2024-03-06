//From the given string, take the characters and make palindrome, what is the longest length of the possible palindrome
//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public int longestPalindrome(String s) {
        //using hashset
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        //getting the character 1-1
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            //if the set contains the character 
            //increase the count and remove the character
            //if the set contains the character
            //if it does update the count by 2
            // remove the character
            // else add to set set.add(c) 
            if(set.contains(c)){
                count+=2;
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        // if the set is not empty
        // count++
        if(!set.isEmpty()){
            count++;
        }
        // return the count
        return count;
    }
}