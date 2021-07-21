class LongestPalindrome {
    //time:O(n)
    //space: O(n)
    //did it run successfully on leetcode: yes
    public int longestPalindrome(String s) {
         //creating a hashmap
        HashSet <Character> set = new HashSet<>();
        //initializing count
       int count = 0;
    //looping through string
       for(int i = 0; i < s.length(); i++){
        
           char c =  s.charAt(i);
            // if set contains curr character
           if(set.contains(c)){
               //remove curr character from set 
               set.remove(c);
            // increase count by 2
               count += 2;
            // if set doesn't contains curr character
           } else {
                // add curr character to set
               set.add(c);

           }

       }
    //if set is not empty
       if(!set.isEmpty()){
            //increement count
           count++;

       }

       return count;
    }
}