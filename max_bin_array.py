"""
Time Complexity: O(n)
Space Complexity: O(n)
Did your code run on leetcode? : yes
Issues Faced:


"""

class Solution:
    def findMaxLength(self, nums):
        cs, si, l = 0,-1,0
        max = 0
        hp = dict({0 : -1})
        for x in range(len(nums)):
            # print("i am in for loop")
            if nums[x] == 1:
                cs -= 1
            else:
                cs += 1
            # print("cs=", cs)
            if cs in hp:
                l = x - hp[cs]
                # print("l=", l)
                if max < l:
                    max = l
                    # print("max=", max)
            else:
                hp[cs] = x
                # print("hp=", hp)
        return max
# Driver code
#if __name__ == '__main__':
 #   A = Solution()
  #  print(A.findMaxLength([0,0,1,0,0,0,1,1]))
