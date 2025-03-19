class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        boolean flag = false;
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()){
            if(!freq.containsKey(c))
            {
                freq.put(c, 1);
            }
            else
            {
                int temp = freq.get(c);
                freq.put(c, temp + 1);

            }
        }
        System.out.print(freq);
        for(char c : freq.keySet()){
            int v = freq.get(c);
            if(v%2 == 0 ){
                count = count + v;
            }
            else{
                count = count + (v -1);
                flag = true;
            }
        }
        if(flag){
            return count + 1;
        }
        else {
            return count;
        }
    }
}
