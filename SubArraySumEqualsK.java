import java.util.HashMap;
import java.util.HashSet;

// similar to the contiguous sub array
// we now want to count the number of subarrays with target 7
// we calculate the running sum
// we negate target from the current running sum and alongside how many times it occurred
// with every subarray we encouter we will increment the counter by 1

public class SubArraySumEqualsK {

    public static void main(String[] args)
    {
        int[] array = {1};
        int target = 0;
        System.out.println("Possible Subarrays = " + subArrays(array,target));
    }

    //Time Complexity: O(n)
    //Space Complexity : O(n)
    public static int subArrays(int[] array, int target)
    {
        int count = 0;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i = 0; i < array.length; i++)
        {
            
            sum += array[i];

            if(map.containsKey(sum - target))
            {
                count += map.get(sum - target);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return count;
    }

}
