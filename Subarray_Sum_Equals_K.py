def sum_subarray(nums,k):
    ans =0
    #Initializing prefixsum with first number of array
    prefixsum=[nums[0]]
    dict={}
    dict[0]=1
    #starting from second element in the nums array and summing up it with last (-1) index of accumulated sum
    for i in nums[1:]:
        prefixsum.append(prefixsum[-1]+i)

    for i in prefixsum:
        if i-k in dict:
            ans += dict[i-k]
        #Get item of dict[i] and incement it, if not available then default value of get is set to 0  
        dict[i]=dict.get(i,0)+1
    return ans

print(sum_subarray([1,2,3],3))