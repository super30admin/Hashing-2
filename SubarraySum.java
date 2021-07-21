class SubarraySum {
    //time:O(n)
    //space: O(n)
    //did it run successfully on leetcode: yes
    public int subarraySum(int[] nums, int k) {
        
        //creating a hashmap
         HashMap<Integer, Integer> map = new HashMap<>();
    //initializing curr sum and count
       int currentSum = 0;

       int count = 0;
    
       map.put(0,1);
    //looping through input
       for(int i = 0; i < nums.length; i++){
           //updating curr sum 
           currentSum += nums[i];
        
           if(map.containsKey(currentSum - k)){
                //update count
               count += map.get(currentSum-k);

           }
            //map contains curr sum
           if(map.containsKey(currentSum)){
            //get curr count
               int newCount = map.get(currentSum);
                //increement curr count
               newCount++;
                //update count in the map
               map.put(currentSum,newCount);
            
               //if map does not contain curr summ
           } else {
            //initialize curr sum to 1
                map.put(currentSum,1);

           }

       }
//return count
       return count;
    }
}