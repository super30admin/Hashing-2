# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Had to look up synatx of dictionary in python online


# Loop through the array to see how many subarrays actually sum to k
# If sum-k is already present in the frequencies dictionary, then increase the count value by the respective frequency
# If sum in frequencies dict, increase the frequency count by 1 for that value respec. if not, add the frequency of that sum key to 1
k=int(input("enter the value of k: "))
array_str=input("enter the array of integers seperated by spaces: ")
array_list=array_str.split()
nums=[int(item) for item in array_list]

sum=0
count=0 
freq={0:1}

for num in nums:
    sum+=num
    if((sum-k) in freq):
        count+=freq[sum-k]
    
    if(sum in freq):
        freq[sum]+=1
    else:
        freq[sum]=1
print(count)


