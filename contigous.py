# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 

# increase teh counter by 1 if '1' found , else if its '0' then decrement the counter.
# if the counter==0, it means there is an equal number of 0s and 1s. to get max_len of that subarray take i+1 (current index+1)
# Store these bvalues in the hash and everytime a count comes, check if it already exists in the hash. If it does, update the max_len to get the longets value. Else add it to hash

nums_str=input("enter the array of 0s and 1s separted by spaces: ")
nums = [int(item) for item in nums_str.split()]
max_len=0
hash={}
count=0
for i in range(len(nums)):
    current=nums[i]
    if(current==0):
        count-=1
    else:
        count+=1
    if count==0:
        max_len=i+1
    if count in hash:
        max_len=max(max_len, i-hash[count])
    else:
        hash[count]=i
print(max_len)