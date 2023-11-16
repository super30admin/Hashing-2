import java.util.HashSet;
import java.util.Set;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Use a set to when a number repeats. If it repeats increase the count by 2. If the
//set has remaining elements, increast the counter by one so that a single element
//can be accomodated inside the palindrome string
class problem3 {
    public int longestPalindrome(String s) {
        Set<Character> sSet = new HashSet<Character>();
        int count = 0;
        for(char c : s.toCharArray()){
            if(sSet.contains(c)){
                count = count+2;
                sSet.remove(c);
            } else {
                sSet.add(c);
            }
        }

        for(char c : sSet){
            count++;
            break;
        }

        return count;

    }
}