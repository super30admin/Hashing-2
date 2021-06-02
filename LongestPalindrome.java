class longestPalindrome {
    public int longestPalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (Char char : s.toCharArray()) {

            if (!map.containsKey(char)) {
                map.put(char, 0);
            }
            map.put(char, map.get(char) + 1);
        }

        int one = false;
        for (Map.Entry element : map.entrySet()) {
            if (element.get() % 2 == 0) {
                count+=2;
            }

            if (element.get() % 2 != 0 && one = false) {
                one = true;
                count+=element.get();
            }
        }

        return count;
        
    }
}