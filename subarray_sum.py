# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Had to look up synatx of dictionary in python online

# Loop through the array to see how many subarrays actually rsum to k
# If rsum-k is already present in the frequencies dictionary, then increase the count value by the respective frequency
# If rsum in frequencies dict, increase the frequency count by 1 for that value respec. if not, add the frequency of that rsum key to 1
k=int(input("enter the value of k: "))
array_str=input("enter the array of integers seperated by spaces: ")
array_list=array_str.split()
nums=[int(item) for item in array_list]
rsum=0
count=0 
freq={0:1}

for num in nums:
    rsum+=num
    if((rsum-k) in freq):
        count+=freq[rsum-k]
    
    if(rsum in freq):
        freq[rsum]+=1
    else:
        freq[rsum]=1
print(count)


