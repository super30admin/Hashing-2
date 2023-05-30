import java.util.HashMap;

public class ContiguousBinarySubarrayLength {

        public int findMaxLength(int[] nums) {

            //create hashmap <running sum, index>

            HashMap<Integer, Integer> map = new HashMap<>();

            // initialise hashmap
            map.put(0, -1);

            int maxLength = 0, runSum = 0, n = nums.length;


            // iterate over nums
            for(int i = 0; i < n; i++){ //O(n)

                //running sum update

                if(nums[i] == 1){

                    runSum++;
                } else{

                    runSum--;
                }

                //if running sum is present in hashmap
                if(map.containsKey(runSum)){

                    //max is difference between current index and the index that running sum occured first, compare with previous max
                    maxLength = Math.max(maxLength, i - map.get(runSum));
                }
                // add running sum to hash map if not there already
                else{

                    map.put(runSum, i); //O(n)
                }
            }
            return maxLength;
        }


        /* Time Complexity is O(n) - for loop
        Space Complexity is O(n)  - if all elements are o or 1
        */

        public static void main(String[] args){

            ContiguousBinarySubarrayLength object = new ContiguousBinarySubarrayLength();

            int[] binaryArray = {1,0,1,0,1,1,0,0,1,0,1,0,0,1,1,1};

            int result = object.findMaxLength(binaryArray);

            System.out.println("Maximum length of a contiguous subarray " +
                    "with an equal number of 0 and 1 is " + result);

        }

}
