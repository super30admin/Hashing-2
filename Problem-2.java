class Solution {
    //Time Complexity :- O(n)
    //Space Complexity :- O(n)
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        hashmap.put(0,-1);
        int rsum = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                rsum = rsum + 1;
            }
            else{
                rsum = rsum - 1;
            }
            if(hashmap.containsKey(rsum)){
                max = Math.max(max,i - hashmap.get(rsum));
            }else{
                hashmap.put(rsum,i);
            }
        }
        return max;
    }
}