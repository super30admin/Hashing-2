# Time Complexity:
# O(n)

# Space Complexity:
# O(1)
class Solution(object):
    def productExceptSelf(self, nums):
        
        n = len(nums)
        result = [1] * n
        
        # Compute prefix products and store in result
        prefix = 1
        for i in range(n):
            result[i] = prefix
            prefix *= nums[i]
        
        # Compute suffix products and multiply with result
        suffix = 1
        for i in range(n - 1, -1, -1):
            result[i] *= suffix
            suffix *= nums[i]
        
        return result
        # 
        # la = [1] * n
        # ra = [1] * n
        # print(la[0])
        # for i in range(n):
        #     if i == 0:
        #         continue
        #     la[i]=la[i-1]*nums[i-1]
        # for j in range(n,0,-1):
        #     if j == n:
        #         continue
        #     ra[j-1]=ra[j]*nums[j]
            
        # result=[x * y for x,y in zip(la,ra)]
        # return result