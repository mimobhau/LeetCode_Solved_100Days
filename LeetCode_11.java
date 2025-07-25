/* LeetCode_11>> CONTAINER With MOST WATER
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

    Example 1:

    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

    Example 2:

    Input: height = [1,1]
    Output: 1

Constraints:
    n == height.length
    2 <= n <= 105
    0 <= height[i] <= 104
 */

import java.util.Scanner;

public class LeetCode_11 {
    private static int Min(int i, int j)
    {
        if(i < j)
            return i;
        else
            return j;
    }

    private static int Solution(int[] nums)
    {
        int area = -1, max = -1;
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                // minimum height = breqdth
                int min = Min(nums[i], nums[j]);
                // diff = length
                int diff = Math.abs(j-i);
                // water volume
                area = min * diff;
                
                if(max < area)
                    max = area;
            }
        }

        return max;
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
