public class ContigousSubarrayTester {
    public static void main(String[] args) {
        ContigousSubarray obj = new ContigousSubarray();

        int[] nums = { 0, 0, 1, 0, 0, 1, 0 };

        System.out.println(obj.findMaxLength(nums));
    }
}
