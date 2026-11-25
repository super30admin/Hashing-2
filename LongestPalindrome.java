/*
TC: O(n)
SC: O(1)

Approach :
use a set to keep the track of prevously encountered element if you find a math add 2 and remove it from the set. at the end if there are still things
*/
class Solution {
    public int longestPalindrome(String s) {
        int count =0;
        HashSet<Character> set = new HashSet<>();
        for (int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                count+=2;
                set.remove(c);
            }
            else{
                set.add(c);
            }
        }
        if(!set.isEmpty()){
            count+=1;
        }
        return count;
    }
}
}