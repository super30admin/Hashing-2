import java.util.HashSet;

class LongestPalindrome {
    //Need to return the size of longest palindrome possible from a give String.
    //Maintain the HashSet of odd chars, maintain count and return count if HashMap is empty, if not then add 1 to count and return count.
    //TC will be O(n), as iterating over all the chars in the string.
    //SC will be O(1), as HashSet can have max 26(lower case alphabets) & 26(upper case alphabets.)

    public int longestPalindrome(String s) {
        if(s== null || s.length()==0){      //Base condn to check if string is empty.
            return 0;
        }

        HashSet<Character> set= new HashSet<>();       //HashSet to store the odd no. of characters.
        int count=0;        //Variable to store the max count.

        for(int i = 0; i < s.length(); i++){      //to iterate over the string
            char c = s.charAt(i);       //to get char from string at index i.
            if(set.contains(c)){           //Cond to check if set already conatins key
                count +=2;                  //pair found increment count by 2
                set.remove(c);              //remove the char from HashSet.
            }
            else{
                set.add(c);             //If not then add to HashSet
            }
        }
        if(!set.isEmpty()){         //Cond to check if set is empty or not
            count+=1;               //If not then add 1 to count as those elements can be added in middle to make longest palindrome string
        }
        return count;           //Return count
    }

    public static void main(String[] args){
        LongestPalindrome obj = new LongestPalindrome();
        String s = "abccccdd";
        System.out.println(obj.longestPalindrome(s));
    }
}