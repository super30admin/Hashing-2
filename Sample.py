#ime Complexity : O(N)
#Space Complexity : 0(N)
# Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO
# Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
# USED RUNNING SUM AND STORED THE SUM OF TIMES THAT SUM HAS BEEN ENCOUNTERED IN A HASHMAP

def subarraySum(self, nums: List[int], k: int) -> int:
       
        count = 0 
        mydict = defaultdict(int)
        mydict[0] += 1
        mysum = 0 
        for i in range(len(nums)):
            mysum += nums[i]
            if (mysum - k) in mydict:
                count += mydict[mysum-k]
            mydict[mysum] += 1
        return count 

# Time Complexity : 0(N)
# Space Complexity : 0 (N)
# Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO
# Problem2 (https://leetcode.com/problems/contiguous-array/)
# USED RUNNING SUM TO STORE THE INDICES OF THE RUNNING SUM AND USING COUNT TO INCREEMENT EVERYTIME WE GT 1 AND DECREMENT WHEN WE GET 0

        dic = {}
        dic[0] = -1
        ans = 0
        count = 0
        for i in range(len(nums)):
            if nums[i] == 1:
                count += 1
            else:
                count -= 1
            if count in dic:
                ans = max(ans, i - dic[count])
            else:
                dic[count] = i
        return ans

# Time Complexity : 0 (N)
# Space Complexity : O (N)
# Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO
# Problem3(https://leetcode.com/problems/longest-palindrome)
# USING HASET TO STORE PAIRS OF ELEMENTS AND AT THE END ADDING 1 TO ACCOUNT FOR ANY ODD NUM OF ELEMENTS PRESENT 

def longestPalindrome(self, s: str) -> int:
        myhash = set()
        res = 0 
        for i in s:
            if i in myhash:
                res += 2
                myhash.remove(i)
            else:
                myhash.add(i)
        return res + 1 if len(myhash) > 0 else res