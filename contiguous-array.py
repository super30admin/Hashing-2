# time: O(n), space: O(n)\

# track total zeros and ones at each position
# diff_index tracks the diff between ones and zeros count (key) with index we saw that diff at (value)
# see if the diff is in the map, if so get the index and subtract current index minus that index max with res

class Solution:
	def findMaxLength(self, nums: List[int]) -> int:
		zero = 0
		one = 0
		res = 0
		diff_index = {}

		for i,n in enumerate(nums):
			if n == 0:
				zero+=1
			else:
				one+=1
			if one - zero not in diff_index:
				diff_index[one-zero]=i

			if one == zero:
				res = one+zero 

			else:
				idx = diff_index[one-zero]
				res = max(res, i-idx)

		return res 