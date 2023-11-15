// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int longestPalindrome(String s) {

        // Set<Character> set = new HashSet<>();
        boolean set[] = new boolean[60];

        int len = 0;

        for(char c: s.toCharArray()){
            if(set[c - 'A']){
                len += 2;
                set[c - 'A'] = false;
            }else{
                set[c - 'A'] = true;
            }
        }

        for(int i=0; i< set.length; i++){
            if(set[i]){
                len++;
                break;
            }
        }

        //  Using Hashset
        // for(char c: s.toCharArray()){
        //     if(!set.contains(c))
        //         set.add(c);
        //     else {
        //         len += 2;
        //         set.remove(c);
        //     }
        // }
        // if(set.size() != 0) len++;
        return len;
    }
}