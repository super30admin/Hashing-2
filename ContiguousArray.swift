//
//  ContiguousArray.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/3/26.
//

/*
 Balanced array/ contiguous array - having equal no of 0s and 1s
 [0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0...]
 n, n-1, n-2, n-3, ....3,2,1, -> sum of all. aithmetic progression. n(n+1)/2 == n2 time complexity
 //to check the balanced subarrays (having equal no of 0s and 1s) - n2 to form all subarrays. O(n) to check if it's subarray. So total time complexity - O(n3)
 
 to check 0s and 1s - for each 0, reduce count by 1. For 1, increase the count by 1. If this counts become s0 at kast, it means it;s balanced subarrays.
 When the running sum becomes equal, we have balanced subarrays
 //check if a particular running sum happened before. How to check if a runnin gsum happened before or not ? -> Hash map
 hashmap is a data structure - to search effectively in O(1)
 
 Running sum / prefix sum -
 [1, 2, 3,  4,  5, 6,  7,  8,  9,]
 1,  3, 6, 10, 15, 16, 23, 31, 40
 
 Time complexity -> O(n)
 Space complexity -> O(n)
 
 Edge case - if the balanced suabarray is startng from index 0, we are not able to catch
 so, make a dummy entry for catching (-1, 0) (the running sum is 0 at -1 index) to catch the subarray starting from 0th index. Because
 Index of the balanced subarray is starting from (index+1). index is the array index where the sum is equal to the current index's sum.
 We are eliminating nested array because if we have value of x and y, then we can calculate z if x-y = z. z happens to be the nested iteration.
*/

import Foundation

class ContiguousArray {
    
    //Running sum problem
    //with equal no of 0s and 1s
    func findMaxBalancedArrayLength() -> Int {
        //[0,1] = output 1. balanced array
        //[0,1,0] -> output 2, [0,1] & [1,0]
        let nums = [0, 1, 1, 1, 1, 1, 0, 0, 0]
        
        var maxLength = 0
        //first create a counter variable. Incremenet it in presence of 1, decrement it in presence of 0
        var sumMap: [Int: Int] = [0: -1] //sum is 0 at -1 index [sum: index]
        var rSum = 0 // at
        for i in 0..<nums.count {
            if (nums[i] == 0) {
                //decremtn counter by 1
                rSum -= 1
            } else {
                //increment counter by 1
                rSum += 1
            }
            
            if (sumMap[rSum] != nil) {
                //it means this counter already exists in the map, so take that out and the current one, find the difference. Thta would be the balanced subarray.
                let existinIndexWithTheSameSum = sumMap[rSum]!
                if (i - existinIndexWithTheSameSum > maxLength) {
                    maxLength = i - existinIndexWithTheSameSum
                }
//                maxLength = max(maxLength, i - sumMap[rSum]!)
            } else {
                sumMap[rSum] = i //for a particular sum, save the index
            }
        }
        
        //to find the longest subarray with equal no of 0s and 1s.
        return maxLength
    }
    
    func findLengthOfLongestBalancedSubarray() -> Int {
        let nums = [0, 1, 1, 1, 1, 1, 0, 0, 0]
        if nums.isEmpty { return 0 }
        
        var map: [Int: Int] = [Int: Int]()
        var maxLen = 0
        var rSum = 0 //runningSum
        map[0] = -1 // 0 sum happend at -1 index
//        var start = 0
//        var end = 0
        for i in 0..<nums.count {
            if (nums[i] == 0) {
                rSum -= 1
            } else {
                rSum += 1
            }
            //check if the sum is contained in the map
            if (map[rSum] != nil) {
                //so length of current subarray is
                var curr = i - map[rSum]!
//                if (maxLen < curr) {
//                    maxLen = curr
//                    start = map[rSum]
//                    end = i
//                }
                maxLen = max(maxLen, curr)
            } else {
                map[rSum] = i
            }
        }
        return maxLen
    }
    
    init() {
         let maxLength = findLengthOfLongestBalancedSubarray()
        print("maxLength *** \(maxLength)")
        let len = findMaxBalancedArrayLength()
       print("length *** \(len)")

    }
}

