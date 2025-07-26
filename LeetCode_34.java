/* LeetCode_34>> FIND FIRST and LAST POSITION of ELEMENT in SORTED ARRAY
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

    Example 1:

    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]

    Example 2:

    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]

    Example 3:

    Input: nums = [], target = 0
    Output: [-1,-1]

Constraints:
    0 <= nums.length <= 105
    -109 <= nums[i] <= 109
    nums is a non-decreasing array.
    -109 <= target <= 109
 */

import java.util.Scanner;

public class LeetCode_34 {
    private static void Solution(int[] nums, int target)
    {
        int[] ans = {-1, -1};
        if(nums.length == 0)
        {
            for(int i=0; i<ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
        }

        ans[0] = firstOccurence(nums, target);
        ans[1] = lastOccurence(nums, target);

        for(int i=0; i<ans.length; i++)
        {
            System.out.print(ans[i] + " ");
        }
    }

    private static int firstOccurence(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length - 1;

        int ans= -1;

        while(start <= end)
        {
            int mid = (start + end)/2;

            if(nums[mid] == target)
            {
                ans = mid;
                end = mid-1;
            }
            else if(nums[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }

        return ans;
    }

    private static int lastOccurence(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length - 1;

        int ans= -1;

        while(start <= end)
        {
            int mid = (start + end)/2;

            if(nums[mid] == target)
            {
                ans = mid;
                start = mid+1;
            }
            else if(nums[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }

        return ans;
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
        
        Solution(nums, target);

        sc.close();
    }
}
