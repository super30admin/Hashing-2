#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Feb 10 21:17:29 2026

@author: rishigoswamy

    Problem: Subarray Sum Equals K
    Link: https://leetcode.com/problems/subarray-sum-equals-k/

    Approach:
    Use Prefix Sum + HashMap to store frequency of prefix sums.

    Time Complexity: O(n)
    Space Complexity: O(n)

"""

from typing import List

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        hMap = {}
        prefixSum = 0

        for item in nums:
            prefixSum += item
            if prefixSum == k:
                count+=1
            if prefixSum - k in hMap:
                count+= hMap[prefixSum - k]
            if prefixSum not in hMap:
                hMap[prefixSum] = 1
            else:
                hMap[prefixSum]+= 1
            
        return count