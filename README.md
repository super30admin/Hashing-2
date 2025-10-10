# Hashing-2

Explain your approach in **three sentences only** at top of your code


## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)


## Problem2 (https://leetcode.com/problems/contiguous-array/)


## Problem3 (https://leetcode.com/problems/longest-palindrome)
I used set data structure 

iterate each element of a string into a set and add if not existing
if existing remove and increment the count to 2 
if the final set is not empty that measn there is  is possibility of adding that element in the middle 

increment the count to 1 if not empty set 

Timecomplexity: 

iterate all elements =O(N)
searching hashset = O(26)
Total : O(n)

space complexity:

storing 26 elements max in worst case in a set : O(26)--> O(1)

