public class Problem3 {
    //Time complexity : o(n)
    //Space complexity : o(n)
    public int longestPalindrome(String s) {
        //if you encounter an element for the first time
        //put it in set, if you encounter it again and increment the countby2 & remove         //the element.
        if(s == null || s.length() == 0){ return 0; }
        int count=0;
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(set.contains(c)){
                count+=2;
                set.remove(c);
            }else{
                set.add(c);
        }
        }
        return (set.size()==0)?count:count+1;
}
}
