public class IncresingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,5,0,4,1,3};
        System.out.println(increasingTriplet(nums));
    }

    private static boolean increasingTriplet(int[] nums) {

        int start, middle, end;

        for (start = 0; start < nums.length - 2; start++) {
            for (middle = start + 1; middle < nums.length - 1; middle++) {
                if (nums[start] < nums[middle]) {
                    for (end = nums.length - 1; end > middle; end--) {
                        if (nums[middle] < nums[end])
                            return true;
                    }
                }
            }
        }
        return false;
    }
}
