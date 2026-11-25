/*
TC:O(n)
SC: O(n)
Approach :
Running sum

*/
class FindMaxLength {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int rsum =0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){
                rsum-=1;
            }
            else{
                rsum+=1;
            }
            if(map.containsKey(rsum)){
                max = Math.max(max, i-map.get(rsum));
            }
            else{
                map.put(rsum,i);
            }
        }
        return max;
    }
}