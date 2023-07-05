// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
import java.util.HashMap;

public class LongestContiguousSubArray {

    public static int findMaxLength(int[] nums) {

        if(nums == null || nums.length == 0) return -1;
        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        //map.put(0,-1);
        int runningSum = 0;
        int startIndex = 0 , endIndex = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0) runningSum--;
            else runningSum++;

            if(map.containsKey(runningSum)){
                max = Math.max(max, i - map.get(runningSum));
                /*
                //int tempMax = max;
                if(tempMax < max)
                {
                    startIndex = map.get(runningSum)+1;     // update startInddex and endIndex only when max number is increased.
                    endIndex = i;
                }*/

            }else map.put(runningSum, i);

        }
        /*System.out.println("startIndex : "+startIndex);
        System.out.println("endIndex : "+endIndex);
        for(int i=startIndex; i<=endIndex; i++) // printitng the longest contiguous sub array
            System.out.print(nums[i]);*/
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1,0,0,0,1};
        System.out.println(findMaxLength(arr));
    }
}
