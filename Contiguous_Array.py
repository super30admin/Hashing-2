def cont_subarray(nums):
    subarray, count=0,0
    dict={}
    for i in range(len(nums)):
        #setting count to -1 for 0's and +1 for 1's so we can check on balance between equal 0's and 1's if count is 0 in order to get sum as 0 
        if nums[i]==0:
           count-=1
        else:
            count+=1

        #if 0 means balance is found so we set subarray to the cuurent index length
        if count==0:
            subarray=i+1
        #if same count is occured before, then indices betwen their occurance has equal 0's and 1's
        #count if subarray length having count 0
        if count in dict:
            subarray=max(subarray,(i-dict[count]))
        else:
            #Mapping dictionary for checking future occurances
            dict[count]=i
    return subarray
        

print(cont_subarray([0,0,1,0,0,1,1]))