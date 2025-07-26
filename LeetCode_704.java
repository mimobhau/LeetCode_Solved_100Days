/* LeetCode_704>> BINARY SEARCH
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

    Example 1:

    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
    Explanation: 9 exists in nums and its index is 4

    Example 2:

    Input: nums = [-1,0,3,5,9,12], target = 2
    Output: -1
    Explanation: 2 does not exist in nums so return -1

Constraints:
    1 <= nums.length <= 104
    -104 < nums[i], target < 104
    All the integers in nums are unique.
    nums is sorted in ascending order.
 */

import java.util.Scanner;

public class LeetCode_704 {
    private static int Solution(int[] nums, int target)
    {
        // start pointer
        int start = 0;
        // end pointer
        int end = nums.length - 1;

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

        return -1;
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
