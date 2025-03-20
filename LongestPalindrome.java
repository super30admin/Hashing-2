// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :



class Solution {
    public int longestPalindrome(String s) {
       Character[] set = new Character[100]; // null values -> 0
       int count = 0;

       for(char c: s.toCharArray()){
        if(set[c - 'A'] !=null) {
            count += 2;
            set[c - 'A'] =null;
        } else {
            set[c - 'A'] =c;
        }
       }

    //    if(set.size() > 0) return count + 1;
    //    return count;
       if(s.length() == count) return count;
       return count+1;
       
    }
}

//With boolean
// class Solution {
//     public int longestPalindrome(String s) {
//        boolean[] set = new boolean[100]; // null values -> 0
//        int count = 0;

//        for(char c: s.toCharArray()){
//         if(set[c - 'A']) {
//             count += 2;
//             set[c - 'A'] =false;
//         } else {
//             set[c - 'A'] =true;
//         }
//        }

//     //    if(set.size() > 0) return count + 1;
//     //    return count;
//        if(s.length() == count) return count;
//        return count+1;
       
//     }
// }