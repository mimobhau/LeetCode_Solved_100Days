/* LeetCode_977>> SQUARES of a SORTED ARRAY
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

    Example 1:

    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].

    Example 2:

    Input: nums = [-7,-3,2,3,11]
    Output: [4,9,9,49,121]

Constraints:
    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in non-decreasing order.

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */

import java.util.Scanner;

public class LeetCode_977 {
    public static void Solution(int[] nums)
    {
        // pointers for the input array
        int start = 0;
        int end = nums.length - 1;

        int[] newArr = new int[nums.length];
        // pointer for the sorted array
        int ptr = nums.length - 1;

        /*
         * my way
            
            for(int i=0; i<nums.length; i++)
            {
                nums[i] = nums[i]*nums[i];
            }

         
            // sorting array and putting it into new array
            for(int i=0; i<nums.length; i++)
            {
                if(nums[start] > nums[end])
                {
                    newArr[ptr] = nums[start];
                    start++;
                    ptr--;
                }
                else
                {
                    newArr[ptr] = nums[end];
                    end--;
                    ptr--;
                }
            }
        */

        while(start <= end)
        {
            int fSquare = nums[start]*nums[start];
            int lSquare = nums[end]*nums[end];

            if(fSquare > lSquare)
            {
                newArr[ptr] = fSquare;
                start++;
            }
            else
            {
                newArr[ptr] = lSquare;
                end--;
            }

            ptr--;
        }

        for(int i=0; i<nums.length; i++)
        {
            System.out.print(newArr[i] + " ");
        }
        // printing sorted Squared array
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

        Solution(nums);

        sc.close();
    }
}
