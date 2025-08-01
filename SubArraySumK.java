    //Idea is to use cummulative sum or running sum to calculate the number of sub arrays with sum k
    // Cummulative sum and their counts are stored in HashMap.
    //If the cummulative sum  till an element minus K is already present in hashmap, 
    //it means the sub array with sum k is found. This corresponding count will be added to final value. 

    //Time Complexity:O(n)
    //Space Complexity:O(n) 
public class SubArraySumK {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
