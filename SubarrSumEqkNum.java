import java.util.HashMap;

public class SubarrSumEqkNum {


        public int subarraySum(int[] nums, int k) {


            // create hashmap <running sum, number of its occurrences
            HashMap<Integer, Integer> map = new HashMap<>(); //O(n)

            // edge case
            map.put(0, 1);

            int runSum = 0, n = nums.length, subarrNum = 0;

            // iterate over nums
            for(int i = 0; i < n; i++){ // O(n)

                // cumulatively add element to the running sum
                runSum += nums[i];

                // if complement is present in hashmap
                if(map.containsKey(runSum - k)){

                    // add value of complement to the result as it yields that many subarrays adding to target sum
                    subarrNum += map.get(runSum - k);
                }

                if(!map.containsKey(runSum)){

                    //initiate a new running sum
                    map.put(runSum, 0);
                }
                // add 1 to value if running sum is already present
                map.put(runSum, map.get(runSum) + 1);
                //map.put(runSum, getOrDefault(runSum, 0) + 1)


            }
            return subarrNum;
        }


        /*
        Time Complexity = O(n) - for loop
        Space Complexity = O(n) - as each running sum can be different and
        maximum length of hashmap depends on length of nums
        */

        public static void main(String[] args){

            SubarrSumEqkNum object = new SubarrSumEqkNum();

            int[] arr = {3, 4, 7, 2, -3, 1, 4, 2, 0, 1};

            int tar = 7;

            int result = object.subarraySum(arr, tar);

            System.out.println("the total number of sub arrays whose sum equals to k is " + result);

        }
}
