class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                count += 2;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        if(!set.isEmpty()){
            count++;
        }
        return count;
    }
}

//TC: O(n)
// SC: O(1) -> Hashset would have max 26 chars which is constant

//code to print the string
/* class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        int pos = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                count += 2;
                sb.insert(pos, ch).insert(pos+1, ch);
                pos++;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        if(!set.isEmpty()){
            count++;
            Iterator<Character> iterator = set.iterator();
            sb.insert(pos, iterator.next());
        }
        System.out.print(sb.toString());
        return count;
    }
} */