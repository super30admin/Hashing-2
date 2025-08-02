class Solution {
    public int longestPalindrome(String s) {
        // To have longest palindrom occurence of repeated character must be even & 1 odd
        // if all are odd take character with max odd no.

        HashMap<Character,Integer> map = new HashMap<>();

        for( int i = 0; i < s.length(); i++ ){
            char letter = s.charAt(i);

            map.put( letter , map.getOrDefault(letter , 0) + 1 ); // creating hashMap with occurrence
        }

        int result = 0;
        int maxOdd = 0; // To find max occurence of odd occurence
        int saveKey = 0;
        for( char i : map.keySet() ){
            if( map.get(i) % 2 == 0 ){
                result += map.get(i);
            }
            else{

                if( maxOdd < map.get(i) ){
                    maxOdd = map.get(i);
                    saveKey = i; // so that when rest other odd -1 are added this char's occurence can be skipped

                }

            }
        }

        result += maxOdd;

        for( char i : map.keySet() ){
            if( map.get(i) % 2 != 0 ){
                if( i != saveKey ){
                    result += map.get(i) - 1; // adding to result remaining odd ny reducing 1 to make it even
                }
            }

        }



        return result;

    }
}