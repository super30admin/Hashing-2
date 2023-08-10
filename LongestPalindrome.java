class LongestPalindrome{
// Time Complexity : o(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
    public int findLongestPalindrome(String s){
        int count = 0;
        HashSet<Character> set = new HashSet<Character>(); // Set keep count of character.
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                count = count + 2; //If any character coming twice will increase the count by 2 and remove from set. 
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        if(!set.isEmpty()) count++;
        return count;
    }
}