/* LeetCode_747>> LARGEST NUMBER At Least TWICE of OTHERS
You are given an integer array nums where the largest integer is unique.

Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.

    Example 1:

    Input: nums = [3,6,1,0]
    Output: 1
    Explanation: 6 is the largest integer.
    For every other number in the array x, 6 is at least twice as big as x.
    The index of value 6 is 1, so we return 1.

    Example 2:

    Input: nums = [1,2,3,4]
    Output: -1
    Explanation: 4 is less than twice the value of 3, so we return -1.

Constraints:
    2 <= nums.length <= 50
    0 <= nums[i] <= 100
    The largest element in nums is unique.
 */

import java.util.Scanner;

public class LeetCode_747 {
    private static int Solution(int[] nums)
    {
        int max = -1, maxIndex = -1;
        int n = nums.length;
        // getting the max element & its index in the array
        for(int i=0; i<n; i++)
        {
            if(max < nums[i])
            {
                max = nums[i];
                maxIndex = i;
            }
        }

        // checking for the given property
        for(int i=0; i<n; i++)
        {
            if(nums[i] != max && 2*nums[i] >= max)
            {
                return -1;
            }
        }

        return maxIndex;
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
        
        int result = Solution(nums);
        System.out.print("Result: " + result);

        sc.close();
    }
}
