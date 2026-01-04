class Solution {
    public int longestPalindrome(String s) {
        // HashSet approach
        // TC= O(n) iterate over the string length
        // SC = O(1) max of 52 characters can be present in the hashset.
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) { // check if a character is already present in the set, if its add count+2 and
                                   // remove the element.
                count += 2;
                set.remove(c);
            } else { // if not, add the character to the set
                set.add(c);
            }
        }
        if (set.size() >= 1) { // if the set is not empty, it means there's another character that could be
                               // added into the palindrome.
            count += 1;
        }
        return count;

        // Solution 2: HashMap approach
        // TC = O(n)
        // SC = O(1) max of 52 characters can be present in the hashset.

        // HashMap<Character, Integer> map = new HashMap<>();
        // int count =0;
        // for (int i=0; i<s.length(); i++) {
        // char c = s.charAt(i);
        // map.put(c, map.getOrDefault(c,0)+1);
        // }
        // boolean odd = false; // Variable to keep track if a odd counted character is
        // added or not.
        // for(Integer value : map.values()){
        // if(!odd && value%2==1) { // if odd numbered character is not added yet
        // count += value; // add the value
        // odd =true;
        // } else if(value%2==1) { // if an odd numbered charater is already added, then
        // one less even number.
        // count +=value-1;
        // } else { // all even numbers can be added as is.
        // count +=value;
        // }
        // }
        // return count;
    }
}