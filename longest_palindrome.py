# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : took some time thats it

# Count the occurences of the characters in string and store in a hashmap
# add all the even numbered occurences and Odd_occurence-1 to the total_sum_variable
# add a 1 to teh sum value of there was atleast 1 odd numbered occurence in hash

s=input("enter a string: ")
sum=0
char_dict={}
for charac in s:
    if charac in char_dict:
        char_dict[charac]+=1
    else:
        char_dict[charac]=1
for value in char_dict.values():
    sum+=value//2*2
if any(i%2==1 for i in char_dict.values()):
    sum+=1
print(sum)