//
//  SubArraySumK.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/4/26.
//

class SubarraySumK {
    
    //Time compelxity - O(n)
    //Space complexity - O(n
    /*
     find relationship between x, y and z. If we know any of two variables, we can eleiminate nested arrays
     Initially see the brute forcea approach which contains nested iterations. In this case, explore running sum pattern (either running sum happened or compliment has happened)
     For optimizing search, maintain hashing based data structures.
     if we want have frequency or length then use map
     If we want to see if that running sum happened or not, use Set
     
     ***** Keep in mind whether we are missing subarray which are starting from 0th index or not.
     
     Nested iterations can be eliminated by
     1. Prefix sum pattern
     2. Sliding window
     3. Two pointers
     4. Sorted array binary search
     5. hashing
     6. In some case, DP
     7. In some cases - monotonic increasing sum
     
     */
    func subArrayCount() -> Int{
        let input = [3, 4, 7, 2, -3, 1, 4, 2, 0, 1]
        let k = 7
        
        //create a map to keep track of the sum and how many times it occurred
        //Have dummy value [0: 1] which says that sum 0 happened once. This is to catch an edge case where the subarray is starting from index 0.
        var map: [Int: Int] = [0: 1]
        var rSum: Int = 0
        var countOfSubArray = 0
        for index in 0..<input.count {
            //it means the value is present in the map
            rSum = rSum + input[index]
            let compliment = rSum - k
            
            if (map[compliment] != nil) {
                //check if the compliment exist in the map, it means
                countOfSubArray += map[compliment]!
            }
            
            if (map[rSum] != nil) {
                map[rSum]! += 1
            } else {
                map[rSum] = 1 //this rSum has happened once
            }
        }
        return countOfSubArray
    }
    
    init() {
        let count = subArrayCount()
        print("count \(count)")
    }
}
