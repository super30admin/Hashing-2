// Time Complexity : (O)n
// Space Complexity : (O)1
// Did this code successfully run on Leetcode : No. Wrong answer 

// Use hasmap to store the number of character count
//find even number count
//find highest prime number count
//return addition of even and highest prime number count

class Solution {
    func longestPalindrome(_ s: String) -> Int {
        guard s.length > 0 else {return 0}
        var dict = [Character: Int]()
        for c in s {
            if dict[c] != nil {
                dict[c] = dict[c]! + 1
            } else {
                dict[c] = 1
            }
        }
        //get minimum odd number count and even number total
        var evenNumberCount = 0
        var maxHighestOddNumber = 0
        for value in  dict.values {
            if value%2 == 0 {
                evenNumberCount = evenNumberCount + value
            } else {
                maxHighestOddNumber = max(maxHighestOddNumber, value)
            }
        }
        
        return evenNumberCount + maxHighestOddNumber
    }
}