// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * We store the character into the map and remove it on finding its second occurance and keep a track by incrementing the count varaible.
 * If the key is not present, we remove it from the map, else we add it into the map.
 * We check at the end if there are any unpaired characters, and return count+1 to ensure we take only one of those characters into consideration for a palindrome.  
 */
public class longestPalindrome {
        public int longestPalindrome(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int count =0; 
            for(int i=0; i< s.length();i++){
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    count+=2;
                    map.remove(c);
                }
                else{
                    map.put(c,1);
                }
            }
            if(!map.isEmpty())
            return count+1; 
            return count;
}
}
