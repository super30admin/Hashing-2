// Time Complexity : O(N)    //because itirating through all numbers to check sum equal to k
// Space Complexity :O(N)    //using extra space memory 
// Did this code successfully run on Leetcode :   yes


import java.util.*;
public class Main
{
    public  static int subArray(int []nums, int k){
        if(nums==null || nums.length==0){
            return 0;
        }
        HashMap<Integer, Integer> map=new HashMap<>();
        int rsum=0; int count=0; int compliment=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            rsum+=nums[i];
            compliment=rsum-k;
            if(map.containsKey(compliment)){
                count+=map.get(compliment);
            }
            if(!map.containsKey(rsum)){
                map.put(rsum, 0);
            }
            map.put(rsum, map.get(rsum)+1);
        }
        return count;
    }
	public static void main(String[] args) {
		int []nums={3,4,7,2,-3,0,1,4,2};
		int k=7;
		System.out.println("Total number of subArrays sum equal to k is: " +subArray(nums, k));
	}
}
