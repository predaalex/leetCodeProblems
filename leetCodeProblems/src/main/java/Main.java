public class Main {
    public static void main(String[] args) {
        int[] nums = {-1,-1,0,1,1,0};
        int leftSum = 0, rightSum = 0;

        for(int i = 0; i < nums.length; i++) {
            int startLeft = i - 1;
            leftSum = 0;
            while(startLeft >= 0) {
                leftSum+=nums[startLeft];
                startLeft--;
            }

            int startRight = i + 1;
            rightSum = 0;
            while(startRight <= nums.length - 1) {
                rightSum+=nums[startRight];
                startRight++;
            }

            if(rightSum == leftSum)
                System.out.println(i);
        }
        System.out.println(-1);
    }
}
