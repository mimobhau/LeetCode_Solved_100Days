/* LeetCode_334>> INCREASING TRIPLET SUBSEQUENCE
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

    Example 1:

    Input: nums = [1,2,3,4,5]
    Output: true
    Explanation: Any triplet where i < j < k is valid.

    Example 2:

    Input: nums = [5,4,3,2,1]
    Output: false
    Explanation: No triplet exists.

    Example 3:

    Input: nums = [2,1,5,0,4,6]
    Output: true
    Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.

Constraints:
    1 <= nums.length <= 5 * 105
    -231 <= nums[i] <= 231 - 1

Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?
 */

import java.util.Scanner;

public class LeetCode_334 {
    private static boolean Solution(int[] nums)
    {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++)
        {
            // gives the shorter element compared to the previous and next values
            if(first >= nums[i])
                first = nums[i];
            // loops comes here if the next element is larger than the previous(first) element
            else if(second >= nums[i])
                second = nums[i];
            // loops comes here if the next element is larger than the previous(second) element
            else
                return true;
        }

        return false;
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
        
        boolean result = Solution(nums);
        System.out.print("Result: " + result);

        sc.close();
    }
}
