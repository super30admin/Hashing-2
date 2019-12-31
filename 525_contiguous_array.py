class Solution(object):
    def findMaxLength(self, nums):
        """
            // Time Complexity: O(n)
            // Space Complexity: O(n)
            // Did this code successfully run on Leetcode :
                Yes
            // Any problem you faced while coding this :
                Its a really tricky problem.
            // Your code here along with comments explaining your approach:
                We start with an initial
        """
        # initial running total
        running_sum = 0
        # initial running sum is 0
        # we are index 0 with 0 sum
        count_dict = {0: 0}
        # max_length
        max_length = 0
        for index, num in enumerate(nums, 1):  # O(n)
            if num == 0:
                running_sum -= 1
            else:
                running_sum += 1
            if running_sum in count_dict:  # O(1)
                # if we have already seen this sum it means we are back
                # to that same point and the 1's and O's are equal.
                # we can subtract the current index from the index of the
                # index of the first occurance of the same running sum
                max_length = max(max_length, index - count_dict[running_sum])  # O(1)
            else:
                # this is the first time we saw this sum
                count_dict[running_sum] = index  # O(1)
        return max_length


if __name__ == '__main__':
    h = Solution()
    print(f'The length of max contiguous sub array with equal number of 1\'s and zero\'s is \n'
          f'    {h.findMaxLength([0, 0, 0, 0, 1, 1])}')
