// TC O(n)
// SC O(1)

class Solution {
    public int longestPalindrome(String s) {

        // set to store odd occuring characters
        Set<Character> mySet= new HashSet<>();

        int maxLen=0;

        //populate the set by iterating through the string
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            //if char exists in set it means this its second time in a pair.
            if(mySet.contains(c)){
                maxLen+=2;
                mySet.remove(c);
            }else{
                mySet.add(c);
            }
        }
        //if there are odd values set will not be empty
        if(!mySet.isEmpty()){
            maxLen++;
        }
        return maxLen;
    }
}