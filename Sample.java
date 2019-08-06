// Time Complexity :o(n^3)
// Space Complexity : Couldn't identify
// Did this code successfully run on Leetcode : didn't run it in leetcode
// Any problem you faced while coding this : Determining the logic to implement it in an optimized way. Provided only the brute force solution


// Your code here along with comments explaining your approach
#include <iostream>

using namespace std;

int subsum(int arr[],int l,int k)
{
    int count=0;
    //iterating through the array
    for(int i=0;i<l;i++)
    {
        //iterating through subarrays inside an array
        for(int j=i+1;j<=l;j++)
        {
            //computing the sum of subarray and checking if it matches k
            int sum=0;
            for(int p=i;p<j;p++)
            {
                sum+= arr[i];
            }
            if(sum==k)
            {
                count++;
            }
            
        }
    }
    return count;
}

int main()
{
    int arr[]={1,1,1,1,1};
    int k=2;
    int l = sizeof(arr)/sizeof(*arr);
    cout<<subsum(arr,l,k);

    return 0;
}
