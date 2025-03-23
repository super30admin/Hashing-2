class longestPalindrome {
    public int longestPalindrome(String s) {
        boolean flag = false;
        Map<Character, Integer> myMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
                myMap.put(s.charAt(i),myMap.getOrDefault(s.charAt(i), 0)+1);
        }

        int res =0;
        for(Character val: myMap.keySet()){
            if(myMap.get(val)%2 == 0){
                res += myMap.get(val);
            }
            else{
                res += myMap.get(val) -1;
                flag = true;
            }
        }
        if(flag == true)
            return res +1;
        return res;
    }
}