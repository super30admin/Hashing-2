import java.util.HashMap;

public class ContiguousArray {
    //
/*PS BA [0,1] return max length of contiguous array - you are not allowed to skip the subarray with equal numbers of O and 1
BF - start from the first element and iterate till the last element
and run another loop within the first loop to find a subarray with max length of equal 0 and 1.
TC - O(n^2) - just to form the subarray
Techniques to explore
2 pointers
binary search
sliding window
hashing
Running sum pattern
Maintain sum while from source to destination for each element.
destination value - (source-1)value

How it relates with prob
-1 when encountered 0 and add 1 when encountered 1
Maintain running sum at each index
Hashmap put key as running sum and value as the index but only put the starting index
if hashmap contains the element take the value and match it with current running sum value if -2 was first encountered at index 1 and now at 5 then measure the difference between indexes = 4 and the longest length = 4
go ahead if runningsum = -3 then check with old index if it was at index 2 and current = 7 then diff= 5 and the longest length gets updated to 5
Time Complexity - O(n)
Space Complexity - O(n) for the hashmap*/
    public static void main(String[] args) {
        int[] nums = {0,1,0,1};
        int result = findMaxLength(nums);
        System.out.println(result);
    }
    public static int findMaxLength(int[] nums) {
        if(nums== null || nums.length==0) return 0;
        HashMap<Integer,Integer>map = new HashMap<>();
        int rSum = 0;
        int max = 0;
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0) rSum-=1;
            else rSum+=1;
            if(map.containsKey(rSum))
                max = Math.max(max,i-map.get(rSum));
            else map.put(rSum,i);
        }
        return max;
    }

/*
    public static int findMaxLength(int[] nums) {
if(nums==null||nums.length==0) return 0;
int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i+1; j < nums.length ; j++) {
                if(nums[j]==0) count--;
                if(nums[j]==1) count++;
            }
            if(count>max){
                max=count;
            }
        }
        return  max;
    }
*/
    /*
    public static int findMaxLength(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        int countZero = 0;
        int countOne = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0) {

                if (map.containsKey(0)) {
                    countZero = map.get(0);
                   // System.out.println(countZero);
                    map.put(0, countZero + 1);
                }
                if (!map.containsKey(0)) map.put(0, 1);
            }
            if(nums[i]==1){

                if (map.containsKey(1)){
                    countOne = map.get(1);
                   // System.out.println(countOne);
                    map.put(1,countOne+1);
                }
                if(!map.containsKey(1)) map.put(1,1);
            }
        }
       if(map.get(0)==null||map.get(1)==null) return 0;

        return Math.min(map.get(0),map.get(1))*2;



    }
*/

/*
    public static int findMaxLength(int[] nums) {

        int countZero=0;
        int countOne=0;
        List<Integer> listOne = new ArrayList<>();
        List<Integer> listTwo = new ArrayList<>();
        if(nums==null || nums.length==0) return 0;
        for (int i = 0; i < nums.length; i++) {
                if(nums[i]==1){
                    listOne.add(nums[i]);
                    countOne+=1;

                }
            if(nums[i]==0){
                listTwo.add(nums[i]);
                countZero+=1;

            }
            }


        return Math.min(listOne.size(), listTwo.size());
    }

 */
}
