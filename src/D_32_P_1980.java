public class D_32_P_1980 {

    // Function to find a different binary string
    public String findDifferentBinaryString(String[] nums) {
        char[] ans = new char[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i].charAt(i) == '0' ? '1' : '0';
        }

        return new String(ans);
    }

    // Main method to test the function
    public static void main(String[] args) {
        D_32_P_1980 solution = new D_32_P_1980();

        // Example input
        String[] nums = {"01", "10"};

        // Call the function and print the result
        String result = solution.findDifferentBinaryString(nums);
        System.out.println("Different binary string: " + result);
    }
}