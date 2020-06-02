
// Time Complexity : (O)n
// Space Complexity : (O)1
// Did this code successfully run on Leetcode : No. Wrong answer 


class Solution {
    func subarraySum(_ nums: [Int], _ k: Int) -> Int {
        var numberOfSubArray = 0
        var totalNum = 0
        var prevTotalNum = totalNum
        for num in nums {
            totalNum = totalNum + num
            if totalNum == k ||  num == k {
                numberOfSubArray += 1
                totalNum = num
            }else if totalNum < prevTotalNum || totalNum > k {
                totalNum = num
            }
            prevTotalNum = totalNum
        }
        
        return numberOfSubArray
    }
}