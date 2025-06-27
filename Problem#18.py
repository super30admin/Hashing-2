'''
525. Contiguous Array
'''

# Time Complexity : O(n^2) for brute force, O(n) for hashmap approach
# Space Complexity : O(1) for brute force, O(n) for hashmap approach
# Did this code successfully run on Leetcode : Yes, brute force gives TLE for large inputs, hashmap approach works fine
# Any problem you faced while coding this : Yes, understanding how to use hashmap to track counts efficiently

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        # # Brute Force Approach
        # # Time Complexity: O(n^2)
        # # Space Complexity: O(1)
        # max_length = 0 # humne max_length ko 0 se initialize kiya hai kyunki abhi tak humne koi bhi balanced subarray nahi dekha hai (we initialized max_length to 0 because we haven't seen any balanced subarray yet)
        # # We will use a count variable to track the difference between 1s and 0s
        # # Count will be incremented for 1s and decremented for 0s
        # # If count is zero, we have a balanced subarray
        # # hum count variable ka use karenge 1s aur 0s ke beech mein difference track karne ke liye
        # # Count ko 1s ke liye increment kiya jayega aur 0s ke liye decrement kiya jayega
        # # Agar count zero ho jata hai, to humare paas ek balanced subarray hai
        # # humne count variable ko 0 se initialize kiya hai kyunki abhi tak humne koi bhi balanced subarray nahi dekha hai (we initialized count variable to 0 because we haven't seen any balanced subarray yet)    

        # # Iterate through all possible subarrays
        # for i in range(len(nums)): # hum subarrays ke liye nums array ke har index par iterate karte hain (we iterate through each index of the nums array for subarrays)
        #     count = 0 # humne count variable ko 0 se initialize kiya hai kyunki abhi tak humne koi bhi balanced subarray nahi dekha hai (we initialized count variable to 0 because we haven't seen any balanced subarray yet)
        #     for j in range(i, len(nums)): # hum subarrays ke liye nums array ke har index par iterate karte hain (we iterate through each index of the nums array for subarrays)
        #         # Increment count for 1s and decrement for 0s
        #         if nums[j] == 1: # agar current element 1 hai to hum count ko increment karte hain (if the current element is 1, we increment count)
        #             count += 1 # 1 ke liye count ko increment kiya (incremented count for 1)
        #         else: # agar current element 0 hai to hum count ko decrement karte hain (if the current element is 0, we decrement count)
        #             count -= 1 # 0 ke liye count ko decrement kiya (decremented count for 0)
                
        #         # If count is zero, we have a balanced subarray
        #         if count == 0: # agar count zero hai to humare paas ek balanced subarray hai (if count is zero, we have a balanced subarray)
        #             max_length = max(max_length, j - i + 1) # humne max_length ko update kiya hai agar current subarray ka length max_length se zyada hai (we updated max_length if the current subarray's length is greater than max_length)
        #             # j - i + 1 is the length of the current subarray from index i to j
        #             # j - i + 1 current subarray ka length hai index i se j tak
        
        # return max_length # humne max_length ko return kiya hai jo ki balanced subarrays ka maximum length hai (we returned max_length which is the maximum length of balanced subarrays)
        
        # HashMap Approach
        # Time Complexity: O(n)
        # Space Complexity: O(n)
        count = 0 # humne count variable ko 0 se initialize kiya hai kyunki abhi tak humne koi bhi balanced subarray nahi dekha hai (we initialized count variable to 0 because we haven't seen any balanced subarray yet)
        max_length = 0 # humne max_length ko 0 se initialize kiya hai kyunki abhi tak humne koi bhi balanced subarray nahi dekha hai (we initialized max_length to 0 because we haven't seen any balanced subarray yet
        hashmap = {0: -1}  # Initialize with 0 sum having index -1 # humne ye hashmap banaya hai jisme 0 sum ki ek occurrence hai, kyunki agar count k ke barabar ho jaye to hum max_length ko update kar sakte hain (we created this hashmap with one occurrence of 0 sum because if count becomes equal to k, we can update max_length)
        # Iterate through the array
        for i in range(len(nums)): # humne nums array ke har index par i variable ko iterate kiya hai (we iterated through each index of the nums array)
            # Increment count for 1s and decrement for 0s
            if nums[i] == 1: # agar current element 1 hai to hum count ko increment karte hain (if the current element is 1, we increment count)
                count += 1 # 1 ke liye count ko increment kiya (incremented count for 1)
            else: # agar current element 0 hai to hum count ko decrement karte hain (if the current element is 0, we decrement count)
                count -= 1 # 0 ke liye count ko decrement kiya (decremented count for 0)
            # If count is in hashmap, update max_length
            if count in hashmap: # agar count hashmap mein hai to hum max_length ko update karte hain (if count is in hashmap, we update max_length)
                max_length = max(max_length, i - hashmap[count]) # humne max_length ko update kiya hai agar current subarray ka length max_length se zyada hai (we updated max_length if the current subarray's length is greater than max_length)
            else: # agar count hashmap mein nahi hai to hum count ko hashmap mein add karte hain (if count is not in hashmap, we add count to hashmap)
                hashmap[count] = i # humne count ko hashmap mein add kiya hai (we added count to hashmap)
        return max_length # humne max_length ko return kiya hai jo ki balanced subarrays ka maximum length hai (we returned max_length which is the maximum length of balanced subarrays)
    

