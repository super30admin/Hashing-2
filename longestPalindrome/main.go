/*
    To make a palindrome, we need 2 SAME EXACT CHARACTERS
    
    approach: freqMap ( 2 pass )
    - We can build out a freqMap { $char: count }
    - Then since we know we can need 2 count of same exact characters - this also means if the count is 4 , 6,8 ( any even num ) - we can take them all
    - So we can loop over the freqMap
    - and if the char count is even, take them all and add to our len var. delete this key from map
    - if the count is not even, than we can take max even from this count ( count-1 on a odd count will give us the highest even count we can get )
    - Then we will add the even count from odd count and update the count of this odd count char with whatever is left after taking even out. ( count-evenCountThatWeTook )
    - Finally once we have looped over the entire freqMap;
    - if our map still has any data ( i.e len(freqMap) != 0 )
    - We can atleast take 1 character and add to our len ( remember we are not forming the string but just the longest possible len of a palindrome string )
    - Why can we take 1 character and add that to our len count?
    - Because a string is still a palindrome if we can 1 character in the middle.
        - For example: input; abccccdd
        - dccccd - but we can add either a or b in the middle and this will still be a palindrome
        - dccaccd or dccbccd
    time: o(n)+o(26) = o(n)
    space: o(26) = o(1)
    
    approach: freqMap ( 1 pass )
    - While building out a freqMap { $char: count }
        - if a char already exists, and we are trying to add the same one, that means we have exactly 2 counts of this char
        - so here we can add 2 to maxLen and delete that char instead of incrementing the count by 1
        - otherwise, this is the first time we have seen this char, therefore add it and the set count to 1
    - Note: we are not really using the value of the key, so we can likely delete that too and turn the freqMap into just a set{} 
    time: o(n)
    space: o(26) = o(1)

    Potential follow up: print the string that's being formed 
    
*/

func longestPalindrome(s string) int {
    freqMap := map[byte]int{}
    maxLen := 0
    for i := 0; i < len(s); i++ {
        char := s[i]
        _, ok := freqMap[char]
        if ok {
            maxLen += 2
            delete(freqMap, char)
        } else {
            freqMap[char] = 1
        } 
    }
    
    if len(freqMap) != 0 {maxLen++}
    return maxLen
}

