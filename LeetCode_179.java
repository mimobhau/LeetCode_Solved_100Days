/* LeetCode_179>> LARGEST NUMBER
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

    Example 1:

    Input: nums = [10,2]
    Output: "210"

    Example 2:

    Input: nums = [3,30,34,5,9]
    Output: "9534330"

Constraints:
    1 <= nums.length <= 100
    0 <= nums[i] <= 109
 */

import java.util.Scanner;

public class LeetCode_179 {
    private static String Solution(int[] nums)
    {

    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        // for inserting integer array
        System.out.print("Enter size of nums: ");
        int arraySize = sc.nextInt();
        int[] nums = new int[arraySize];
        System.out.print("Enter elements of nums: ");
        for(int i=0; i<arraySize; i++)
        {
            nums[i] = sc.nextInt();
        }
    
        String result = Solution(nums);
        System.out.println("Result: " + result);
        sc.close();
    }
}
