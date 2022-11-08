class Solution:
    """
    Time complexity - O(n) n - length of nums.
    Space complexity - O(n) worst case space complexity
    """
    def findMaxLength(self, nums: list[int]) -> int:
        max_size = 0
        count = 0
        count_map = dict()
        # just keeping track of index
        start_index = 0
        end_index = 0
        # count_map keeps count of count till index as key
        # sum 0 is possible at the beginning
        count_map[0] = -1
        for index, num in enumerate(nums):
            if num == 1:
                count -= 1
            else:
                count += 1
            # check if size of subarray can be replaced
            if count in count_map:
                if max_size < index-count_map[count]:
                    max_size = index-count_map[count]
                    start_index = count_map[count] + 1
                    end_index = index
            else:
                count_map[count] = index
        return max_size
                
                
            
        