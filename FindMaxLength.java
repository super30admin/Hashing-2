
class FindMaxLength {
    //time:O(n)
    //space: O(n)
    //did it run successfully on leetcode: yes
    public int findMaxLength(int[] nums) {
        //creating a hashmap
        Map<Integer, Integer> map = new HashMap<>();
 //initializing max and count
       int max = 0;

       int zero = 0;
        
       //looping through input
       for (int i = 0; i < nums.length; i++) {
            //if curr element is zero, increement zero count
           if (nums[i] == 0) zero++;
           //if curr element is not zero, decrease zero count 
           else zero--;
        // zero count is zero update max
           if (zero == 0) max = i + 1;
          //if map has current zero count  
           if (!map.containsKey(zero)) map.put(zero, i);
            // if zero count doesn't exist in map, update max
           else max = Math.max(max, i - map.get(zero));

       }

       return max;
    }
}