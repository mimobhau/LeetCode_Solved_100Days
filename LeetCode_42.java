/* LeetCode_42>> TRAPPING RAIN WATER
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

    Example 1:

    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

    Example 2:

    Input: height = [4,2,0,3,2,5]
    Output: 9

Constraints:
    n == height.length
    1 <= n <= 2 * 104
    0 <= height[i] <= 105
 */

import java.util.Scanner;

public class LeetCode_42 {
    private static int Solution(int[] height)
    {
        int n = height.length;

        // finding the 'max' height from left side, storing it in an array
        int[] leftMax = new int[n];
        leftMax[0] = height[0];

        // compares, value of height[i] > previous value of leftMax[i]
        // puts the bigger value in leftMax[]
        for(int i=1; i<n; i++)
            leftMax[i] = Math.max(leftMax[i-1], height[i]);

        
        // finding the 'max' height from right side, storing it in an array
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];

        for(int i=n-2; i>=0; i--)
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        
        int ans = 0;
        for(int i=0; i<n; i++)
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];           //returns difference
        
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
    
        int result = Solution(nums);
        System.out.println("Result: " + result);
        sc.close();
    }
}
