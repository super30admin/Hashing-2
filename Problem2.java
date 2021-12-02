public class Problem2 {
      //Time complexity : O(n)
    //Space complexity : O(n)
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();   
        int count=0;
        int rsum=0;
        map.put(0,-1);
        for(int i =0; i<nums.length;i++){
           //calculate sum by incrementing by 1 incase of 1 and decrementing by 1 in case //of 0.Incase we get duplicate key, update the count 
           rsum+=(nums[i]==1)?1:-1;
           if(!map.containsKey(rsum)){
               map.put(rsum,i);
           }else{
               count=Math.max(count,i-map.get(rsum));
           }
        }
        return count;
   }
}
