
//Time Complexity:O(n)
//Space Complexity:O(n)
class Solution {
    public int findMaxLength(int[] nums) {

    int runSum = 0,maxLen=0;

    HashMap<Integer,Integer> rsumMap = new HashMap<>();
    rsumMap.put(0,-1); //Marker to consider 

    for(int i=0;i<nums.length;i++){
        if(nums[i]==0) runSum--;
        else runSum++;

        if(rsumMap.containsKey(runSum)){
            maxLen = Math.max(maxLen, i-rsumMap.get(runSum));
        }
        else{
            rsumMap.put(runSum,i);
        }
    }
    return maxLen;
        
    }
}