class Solution:
    def subarraySum(self, nums,k):
        """
        Approach: 
        1. As the question mentions "total number of continuous subarrays" we can think of running sum            approach.
        2. Here the question asks about the total number of continuous subarrays and not the maximum              length, we will use the value as how many times the running sum value occured previously.
        3. Hashmap will have key as running sum and value as its previous occurances
        4. Everytime we will calculate running sum, we will check runnnig sum - k is present in hasmap            or not, if it is present we can say value associated with thay key number of continuos                  subarrays are present whose sum equals to k. 
        5. This is  as per the running sum property, if we see the sum n -k again it means from                    previous occurance of running sum index upto the repeated n-k index we have again added                numbers whose sum is k
        6. Counter will increase as counter+= no of couurances of n-k
        
        Time Complexity: O(n)
        Space Complexity:O(n)
        """
        if len(nums) == 0:
            return 0

        tracking_dict ={0: 1} #Base Case 0 is seen once
        running_sum = 0
        counter = 0
        for num in nums:
            running_sum = running_sum + num
            if running_sum - k in tracking_dict.keys():
                counter += tracking_dict.get(running_sum - k)
            if running_sum not in tracking_dict.keys():
                tracking_dict[running_sum] = 1
            else:
                tracking_dict.update({running_sum: tracking_dict.get(running_sum) + 1})
        return counter

nums = [-1,-1,1]
k = 0
temp = Solution()
result = temp.subarraySum(nums,k)
print(result)