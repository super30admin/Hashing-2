//
//  LongestPalindrome.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 12/30/25.
//

class LongestPalindrome {
    
    var set: Set<Character> = Set<Character>()
    var count = 0
    
    /*
     "abccccdd" - make longest palindrome.
     1. Approach 1 - Use hashmap, keep on increamenting the frequncy of characters in the map for a unique character. Use even ones and add length 2. T last choose any of a 1 frequency character and make the palindrome.
     Space complexity - O(1)
     time complexity = O(n)
     
     2. Approach 2: Use Set. Add 1 characetr in set. If next character is the same then remove the character from set and add 2 in length. Atlast, you we will have unique character with legth 1. Take any of character and form the palindrome.
     time complexity - O(n) //iterating over the string
     space complexity O (1) perfectly // We will not be cotainging more tha 52 characetrs in the set, So it will be constant.
     
     3. Approach 2
     */
    
    init() {
        let length = findLongestPalindrome(str: "abccccdd")
        print("length \(length)")
    }
    
    func findLongestPalindrome(str: String) -> Int {
        //Approach 2 - Set solutioh
        var set = Set<Character>()
        var lengthOfPalindrome = 0
        for char in str {
            if (set.contains(char)) {
                lengthOfPalindrome += 2
                set.remove(char)
            } else {
                set.insert(char)
            }
        }
        if (!set.isEmpty) {
            return lengthOfPalindrome + 1
        }
        return lengthOfPalindrome
    }
}
