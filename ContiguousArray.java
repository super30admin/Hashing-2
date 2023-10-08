import java.util.HashMap;

// we need to return an array with the equal number of 0's and 1's 
// the logic is that with every 1 and 0  we encounter in the array, when getting 1 we add and with 0 we substract 1
// if the result comes out to be 0 then we have equal number of 0's and 1's in the given subarray
// since it is contiguous we need to keep track of when we encounter a 0
// we do this for all indexes 
// we will be creating a hashmap such that we store the sum and index value we encountered it at
// then while we create the running sum, we go back to the first index where we encoutered it and calculate length
// if length is greater than current length we update, else we go to next index to calculate the running sum
//edge case is we want to have sum 0 at index -1 for cases where it starts with 0 

//thus we use only one hashmap and avoid nested iterations of n^2
// Time Complexity : O(n) 
// Space Complexity : O(n) (all 1's?)

public class ContiguousArray {
    
    public static void main(String[] args)
    {

        int[] arr = {0,1,1};
        System.out.println("Longest Balanced Contiguous SubArray : " + ContiguousArrayLength(arr));

    }

    public static int ContiguousArrayLength(int[] arr)
    {
        int count = 0;
        int sum = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,-1);

        for(int i = 0; i < arr.length; i++)
        {

            if(arr[i] == 0)
            {
                sum = sum - 1;
            }
            else
            {
                sum = sum + 1;
            }

            if(hashMap.containsKey(sum)){
                int new_count = i - hashMap.get(sum);
                count = Math.max(count, new_count);
            }
            else
            {
                hashMap.put(sum, i);
            }
        }

        return count;
    }

}
