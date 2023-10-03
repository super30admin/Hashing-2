# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Had to look up synatx of dictionary in python online


# Input nums (array of int) and k (int) and return the count value of subarrays with sum=k (int)
k=int(input("enter the value of k: "))
# take in the array as a string of numbers and convert it to an int array
array_str=input("enter the array of integers seperated by spaces: ")
array_list=array_str.split()
nums=[int(item) for item in array_list]
# initialize values for variables to store the count of subarrays, a dictionary to store frequencies, an int variable to store sum of array elements
sum=0
count=0 
freq={0:1}
# Loop through the array to see how many subarrays actually sum to k
for num in nums:
    sum+=num
    # If sum-k is already present in the frequencies dictionary, then increase the count value by the respective frequency
    if((sum-k) in freq):
        count+=freq[sum-k]
    # If sum in frequencies dict, increase the frequency count by 1 for that value respec.
    if(sum in freq):
        freq[sum]+=1
    # If not in frequencies dict, add the frequency of that sum key to 1
    else:
        freq[sum]=1
# return or print the count of subarrays that sum to value k
print(count)


