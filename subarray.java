// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int subarraySum(int[] nums, int k) {
        
         HashMap<Integer, Integer> hashMap=new HashMap<>();
        
        int count=0;
        int currentsum=0;
        
        hashMap.put(0,1);
        
        for(int x:nums){
            currentsum += x;
            int diff= currentsum-k;
            
            if(hashMap.containsKey(diff)){
                count+= hashMap.get(diff);
            }
            
            
            if(hashMap.containsKey(currentsum)){
                hashMap.put(currentsum, hashMap.get(currentsum)+1);
            }
            
            else{
                hashMap.put(currentsum,1);
            }
        }
        
        
        return count;
        
        
        
    }
}