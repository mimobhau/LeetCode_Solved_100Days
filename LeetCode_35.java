/* LeetCode_35>> SEARCH INSERT POSITION
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

    Example 1:

    Input: nums = [1,3,5,6], target = 5
    Output: 2

    Example 2:

    Input: nums = [1,3,5,6], target = 2
    Output: 1

    Example 3:

    Input: nums = [1,3,5,6], target = 7
    Output: 4

Constraints:
    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums contains distinct values sorted in ascending order.
    -104 <= target <= 104
 */

import java.util.Scanner;

public class LeetCode_35 {
    private static int Solution(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length-1;

        while(start <= end)
        {
            int mid = (start + end)/2;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }

        // we return start, as while finding the index of the non-existent element, after completing the binary search procedure just before the loop breaks ( start !< end), start is present at the probabale index
        return start;
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
        
        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int result = Solution(nums, target);
        System.out.print("Result: " + result);

        sc.close();
    }
}
