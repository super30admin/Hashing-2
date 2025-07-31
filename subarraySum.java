//I'm using the running sum technique with hash map. so the core idea behind this is i iterate through the array while adding elements at each index I check if the difference between the current sum and the target (sum - target) already exists in the map. If it does, that means I’ve found one or more previous subarrays that would lead to the target sum when combined with the current elements—so I increment my count by the number of times that difference has occurred . And each time sum-target  is present in her map we add the value associated with it to the count variable to keep the track of the number of subways when added lead to the target.


 //here time complexity is O(n) ( n  being the length of the array), since we are Traversing the array only once.

 //the space complexity is O(n),  since we are storing the running sum for each of the item in the array.

class Solution {
    public int subarraySum(int[] nums, int k) {
        int runSum=0;
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i:nums){
            runSum+=i;
            if(map.containsKey(runSum-k)){
                 count+=map.get(runSum-k);
            }

            if(map.containsKey(runSum)){
                map.put(runSum,map.get(runSum)+1);
            }else map.put(runSum,1);
        }
        return count;
    }
}
