/*
Approach -1
Use Rsum - when found 0, subtract, when 1, add 
map contains rsum and index. 
we calculate le based on index stoteed in map for that corresponding rsum, and subtract it from the curr index
update len variable based on Math.max funtion
TC: O(n)
sc:o(n)
*/

class Solution {
    public int findMaxLength(int[] nums) {
        
        int len = nums.length;
        if(nums == null || len ==0) return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        //map <rsum, index>
        
        //base case [0,1] ; [1,0]so we add rsum 0, and index -1 into the map!
        map.put(0, -1);
        int rsum =0;
        int maxlen =0;
        for(int i=0; i< len; i++)
        {
            if(nums[i] == 0) rsum--;
            else
                rsum++;
            
            if(map.containsKey(rsum))
            {
                int currlen = i - map.get(rsum);
                maxlen  = Math.max(maxlen, currlen);
            }else
            {
                map.put(rsum, i);
            }   
        }
        return maxlen;
    }
}