//TC and SC : O(n)
//HashSet Boolean Approach #2
class Solution {
    public int longestPalindrome(String s) {
        boolean[] set = new boolean[100];
        int count = 0;

        for(char c: s.toCharArray()){
            if(set[c - 'A']){ //a = 97, A = 52 
                count += 2;
                set[c-'A']=false;
            }else{
                set[c-'A']=true;
            }
        }
        if(s.length() == count) return count;
        return count+1;
    }
}

// //HashSet character Approach #2
// class Solution {
//     public int longestPalindrome(String s) {
//         char[] set = new char[100];
//         int count = 0;

//         for(char c: s.toCharArray()){
//             if(set[c - 'A'] != 0){ //a = 97, A = 52 // to use null instaed of 0 use Character[] set - primitive datatypes null value stores not the null pointers //
//                 count += 2;
//                 set[c-'A']=0;
//             }else{
//                 set[c-'A']=c;
//             }
//         }
//         if(s.length() == count) return count;
//         return count+1;
//     }
// }
//HashSet Approach #2
// class Solution {
//     public int longestPalindrome(String s) {
//         HashSet<Character> set = new HashSet<>();
//         int count = 0;

//         for(char c:s.toCharArray()){
//             if(set.contains(c)){
//                 count += 2;
//                 set.remove(c);
//             }else{
//                 set.add(c);
//             }
//         }
//         if(set.size()>0) return count+1;
//         return count;
//     }
// }

//HashMap approach 
//TC: O(n)
//SC: O(1)

// class Solution {
//     public int longestPalindrome(String s) {
//         HashMap<Character, Integer> map = new HashMap<>();

//         for(char c : s.toCharArray()){
//             // if(map.containsKey(c)){
//             //     map.put(c, map.get(c)+1);
//             // } else {
//             //     map.put(c,1);
//             // }

//             // or 

//             map.put(c,map.getOrDefault(c,0)+1); //frequency map creation
//         }
//         int count = 0;
//         boolean flag = false;
//         for(char c: map.keySet()){
//             int frq = map.get(c);
//                 if(frq % 2 == 0){
//                     count += frq;
//                 }else{
//                     count += frq-1;
//                     flag = true;
//                 }
//         }
//         if(flag == true) return count + 1;
//         return count;

//     }
// }