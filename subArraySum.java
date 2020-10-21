//Time Complexity: O(n) | Here n is the number of elements in the array
//Space Complexity: O(n)
//Program ran successfully
/*
    Algorithm: 1. Calculate the running sum of each of the elements
               2. At each iteration, put the running sum in the hashmap as the key and the number of occurences of the running sum as value
               3. Also, at each iteration, check if the current sum - k is present in the hashmap
               4. If present, increase the count by the value of the key corresponding to current sum - k.
               5. Return count  
*/

class subArraySum {
    public int subarraySum(int[] nums, int k) {
        //edge cases
        if(nums.length == 0 || nums == null) return -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        int currSum = 0;
        int count = 0;
        map.put(currSum,1);
        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
            int diff = currSum - k;
            if(map.containsKey(diff)){
                count += map.get(diff);
            }
            if(!map.containsKey(currSum)){
                map.put(currSum,1);
            }else{
                int temp = map.get(currSum) + 1;
                map.put(currSum,temp);
            }    
        }
        return count;
    }
}
