//Time Complexity: O(n)
//Space Complexity: O(n)
//Program ran successfully
/*
    Algorithm: 1. A palindrome can have characters whose count is even and one character whose count is odd
               2. Using this property, we add characters to the Hashset
               3. If character is already present then we increment the count by 2 and remove the character
               4. Else we just add the character to the hashset
               5. In the end we check if there are any elements left in the set. If yes, add 1 to the count
               6. Return count
*/
class longPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(char c: s.toCharArray()){
            if(!set.add(c)){
                count += 2;
                set.remove(c);
            }
        }
        if(!set.isEmpty()){
            count += 1;
        }
        return count;
    }
}
