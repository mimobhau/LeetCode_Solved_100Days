/* LeetCode_153>> FIND MINIMUM in ROTATED SORTED ARRAY
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

    Example 1:

    Input: nums = [3,4,5,1,2]
    Output: 1
    Explanation: The original array was [1,2,3,4,5] rotated 3 times.

    Example 2:

    Input: nums = [4,5,6,7,0,1,2]
    Output: 0
    Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

    Example 3:

    Input: nums = [11,13,15,17]
    Output: 11
    Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
 
Constraints:
    n == nums.length
    1 <= n <= 5000
    -5000 <= nums[i] <= 5000
    All the integers of nums are unique.
    nums is sorted and rotated between 1 and n times.
 */

import java.util.Scanner;

public class LeetCode_153 {
    /** Regarding finding Minimum in ROTATED SORTED ARRAY
     *  when the array/sub-array is divided into two halves, the sorted half will not have the minimum element  (as sorted array is rotated, the biggest & smallest element will be beside each other, therefore, unsorted)
     *  if the element next to the current element is smaller, current element is the maximum, while the next element is the minimum
     */
    private static int Solution(int[] nums)
    {
        int start = 0;
        int end = nums.length - 1;

        // if the array has only one value
        if(nums.length == 1)
            return nums[0];
        // if the array is already sorted
        else if(nums[0] < nums[nums.length-1])
            return nums[0];

        while(start <= end)
        {
            int mid = (start + end)/2;

            if(mid!=0 && nums[mid-1] > nums[mid])       //checks if the previous element of 'mid' is bigger than it, making it the minimum
            // "mid!=0" checks for "IndexOutOfBounds" error if (mid=0)
                return nums[mid];
            else if(mid!=nums.length-1 && nums[mid] > nums[mid+1])
            //checks if the next element of 'mid' is bigger than it, making it the minimum
            // "mid!=nums.length-1" checks for "IndexOutOfBounds" error if (mid=end)
                return nums[mid+1];
            else if(nums[start] <= nums[mid])         // shows first half is sorted
            {
                start = mid+1;      // as minimum element is present in the unsorted part
            }
            else         // shows second half is sorted
            {
                end = mid-1;
            }
            
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
        
        int result = Solution(nums);
        System.out.print("Result: " + result);

        sc.close();
    }
}
