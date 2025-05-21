"""
Convert 0 to -1 and check running total
If a total is seen again, the subarray in between has equal 0s and 1s
Make use of a hash map to store first occurrence of each total
"""
"""
Time Complexity: O(n) — One pass through array
Space Complexity: O(n) — To store prefix sums in hash map
"""
class contiguous:
    def findMaxLength(self, nums: list[int]) -> int:

        prefix = {}
        total = 0
        maxlen = 0

        for idx, num in enumerate(nums):

            total += 1 if num == 1 else -1

            if total == 0:
                maxlen = idx + 1

            elif total in prefix:
                maxlen = max(maxlen, idx - prefix[total])
            
            else:
                prefix[total] = idx
        
        return maxlen

if __name__=="__main__":
    nums = [0,1,1,1,1,1,0,0,0]
    obj = contiguous()
    print(obj.findMaxLength(nums))
             


             
        