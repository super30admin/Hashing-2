class Solution {
    public int longestPalindrome(String s) {
        //This solution is using a HashMap
        /*
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: s.toCharArray()){
            // if(map.containsKey(c)){
            //     map.put(c, map.get(c) +1);
            // } else{
            //     map.put(c,1);
            // }

            //OR
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int count = 0;
        boolean flag = false;

        for(char c:map.keySet()){
            int frq = map.get(c);
            if(frq % 2 == 0){
                count += frq;
            } else{
                count += frq - 1;
                flag = true;
            }
        }
        if(flag) return count+1;
        return count;
        */

/*
        //This solution is using a HashSet
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for(char c:s.toCharArray()){
            if(set.contains(c)){ //if the set has that character already then it says we are on a an even occurrence of that character
                count += 2; //just increment the count by 2
                set.remove(c); // then remove that occurrence from the set
            } else{
                set.add(c); //if set it is the first time that character is occurring then add it to the set
            }
        }
        if(set.size() > 0) return count + 1; //if the set has odd occurrences then return the odd character count
        return count;//else return the longest palindrome count
*/

        /*
        //since, u know hashset is nothing but an array, so using boolean array or character array anything is fine
        //this solution is using a character array
        char[] set = new char[100];
        int count = 0;

        for(char c: s.toCharArray()){
            if(set[c-'A'] != 0){
                count += 2;
                set[c - 'A'] = 0;
            } else{
                set[c - 'A'] = c;
            }
        }
        if(s.length() == count) return count;
        return count+1;
        */

        //this solution is using boolean array
        boolean[] set = new boolean[100];
        int count = 0;

        for(char c: s.toCharArray()){
            if(set[c-'A']){
                count += 2;
                set[c - 'A'] = false;
            } else{
                set[c - 'A'] = true;
            }
        }
        if(s.length() == count) return count;
        return count+1;
    }
}
