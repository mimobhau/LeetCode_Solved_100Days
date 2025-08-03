/* LeetCode_2089>> FIND TARGET INDICES After SORTING ARRAY
You are given a 0-indexed integer array nums and a target element target.
A target index is an index i such that nums[i] == target.

Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.

    Example 1:

    Input: nums = [1,2,5,2,3], target = 2
    Output: [1,2]
    Explanation: After sorting, nums is [1,2,2,3,5].
    The indices where nums[i] == 2 are 1 and 2.

    Example 2:

    Input: nums = [1,2,5,2,3], target = 3
    Output: [3]
    Explanation: After sorting, nums is [1,2,2,3,5].
    The index where nums[i] == 3 is 3.

    Example 3:

    Input: nums = [1,2,5,2,3], target = 5
    Output: [4]
    Explanation: After sorting, nums is [1,2,2,3,5].
    The index where nums[i] == 5 is 4.

Constraints:
    1 <= nums.length <= 100
    1 <= nums[i], target <= 100
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeetCode_2089 {
    private static List<Integer> Solution(int[] nums, int target)
    {
        int count = 0, tcount = 0;

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == target)
                tcount++;
            if(nums[i] < target)
                count++;
        }

        // ArrayList<> to store the indices
        List<Integer> ans = new ArrayList<>();

        while(tcount > 0)
        {
            ans.add(count);         // adds the indices of the target to the arraylist, indices that come after elements < target
            count++;
            tcount--;
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
    
        List<Integer> result = Solution(nums, target);
        System.out.println("Result: " + result);
        sc.close();
    }
}
