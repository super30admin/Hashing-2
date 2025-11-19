//Time Complexity: O(n)
//Space Complexity: O(n)
//Solved on leetcode: yes
/*
Approach:
maintained the running balance variable by adding +1 for 1 and −1 for 0.
If the same balance value appears again, it means the subarray between those two positions has equal 0s and 1s.
Used a HashMap to store the first index of each balance and update the maximum length whenever the balance repeats.
 */
import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength_optimized(int[] nums) {
        HashMap<Integer,Integer> firstIndexMap = new HashMap<>();
        int balanceFactor=0;
        int maxLength =0;
        firstIndexMap.put(0,-1);
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                balanceFactor-=1; //if 0 decrement by 1
            } else {
                balanceFactor+=1; //if 1 increment by 1
            }
            if (!firstIndexMap.containsKey(balanceFactor)){
                firstIndexMap.put(balanceFactor,i ); //storing corresponding index value for each running balance
            } else {
                int startIdx = firstIndexMap.get(balanceFactor);
                maxLength = Math.max(maxLength, i-startIdx); //if the balance key repeats, check the length from first index to current index
            }
        }
        return maxLength;
    }

    // brute-force
    //Time Complexity: O(n^3)
    //Space Complexity: O(n)
    /*
    for every subarray check if there are equal number of 1's and 0's
     */
    public int findMaxLength_bruteForce(int[] nums) {
        int maxLength = 0;
        for (int i=0;i<nums.length;i++) {
            for (int j=i;j<nums.length;j++){
                int count0=0;
                int count1=0;
                for (int k=i;k<=j;k++){
                    if (nums[k] == 0){
                        count0+=1;
                    } else {
                        count1+=1;
                    }
                }
                if (count0 == count1){
                    maxLength = Math.max(maxLength, count0*2);
                }
            }
        }
        return maxLength;
    }

    public static void main(String args[]){
        ContiguousArray ca = new ContiguousArray();
        System.out.println(ca.findMaxLength_bruteForce(new int[]{0,1,1,1,1,1,0,0,0,1,1,0,1,0,0,1,1,1}));
        System.out.println(ca.findMaxLength_optimized(new int[]{0,1,1,1,1,1,0,0,0,1,1,0,1,0,0,1,1,1}));

    }
}
