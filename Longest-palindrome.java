// Time Complexity : O(N)    //because itirating through all characters to check
// Space Complexity :Constant    //because alphabets are only lowerCase 26 + upperCase 26
// Did this code successfully run on Leetcode :   yes


// Your code here along with comments explaining your approach


import java.util.*;
public class Main
{
    public  static int longestPalindrome(String strs){
        HashSet <Character> set=new HashSet<>();        //creating hashset to check the occurances of characters 
        int count=0;                                    //to keep the count of possible longest palindrome  
        for(int i=0;i<strs.length();i++){               //itirating  through string
            char ch=strs.charAt(i);                     //storing character of location
            if(!set.contains(ch)){                      //checks whether it  is there in the hashset
                set.add(ch);                            //adds if not in hashset
            }else{          
                count+=2;                               //incrementing count by two because two occurances found
                set.remove(ch);                         //removing available one not to conflict with duplicate occurance 
            }
        }
        if(!set.isEmpty()){                             //if set is not empty then incrementing by 1 because that character could be added in the middle of palindrome
          count++;
        }
        return count;
    }
	public static void main(String[] args) {
	    String strs="abccccdd";
	    System.out.println("Longest possible  palindrome is :" +longestPalindrome(strs));
	}
}