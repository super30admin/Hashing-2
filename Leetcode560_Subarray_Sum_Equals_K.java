//approach - rsum
/*
take a map to store the rsume, and it's freq, saying how many times rsum has occurred/
when running through the array, take diff, and look fror that in map, if exist, fetch its freq, and add it to count, 

irrespective of diff found or not, 
put rsum and freq/udate freq in map

TC: O(n)
sc: O(n)
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        //base case
        if(nums == null) return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        //map<sum, freq- how many time sum has appeared>
        
        int rsum =0;
        map.put(rsum, 1); // to handle base case when [3,4]
        
        int count =0;
        for(int n : nums)
        {
            rsum += n;
            
            int diff =rsum -k ;
            if(map.containsKey(diff))
                count =  count + map.get(diff);
            
            map.put(rsum, map.getOrDefault(rsum,0)+1);
        }
        
        return count;
    }
}