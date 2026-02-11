#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Feb 10 21:19:45 2026

@author: rishigoswamy

    Problem: Contiguous Array
    Link: https://leetcode.com/problems/contiguous-array/

    Description:
    Given a binary array nums, return the maximum length 
    of a contiguous subarray with an equal number of 0 and 1.

    Approach:
    Convert 0 → -1.
    Then the problem becomes:
    Find the longest subarray with sum = 0.

    Use Prefix Sum + HashMap to store the first occurrence 
    of each prefix sum.

    Time Complexity: O(n)
    Space Complexity: O(n)


"""

from typing import List

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        prefixSum = 0
        hMap = {}
        hMap[0] = -1
        res = 0
        for i in range(len(nums)):
            prefixSum += 1 if nums[i] == 1 else -1

            if prefixSum in hMap:
                res = max(res , i - hMap[prefixSum])
            else:
                hMap[prefixSum] = i
        return res  