/* LeetCode_4>> MEDIAN of TWO SORTED ARRAYS
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

    Example 1:

    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
    Explanation: merged array = [1,2,3] and median is 2.

    Example 2:

    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Constraints:
    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -106 <= nums1[i], nums2[i] <= 106
 */

import java.util.Scanner;

public class LeetCode_4 {
    private static double Solution(int[] nums1, int[] nums2)
    {
        int[] tempNum = new int[nums1.length + nums2.length];
        double median = -1;
        int i=0, j=0, k=0;

        /*  we would use it, if we had to just join the arrays

        for(int i=0; i<nums1.length; i++)
        {
            tempNum[n] = nums1[i];
            n++;
        }
        for(int i=0; i<nums2.length; i++)
        {
            tempNum[n] = nums2[i];
            n++;
        }

        // sorts the final array
        Arrays.sort(tempNum);
         */

        //  Sorting the two arrays into a final one
        while(j < nums1.length && k < nums2.length)
        {
            if(nums1[j] <= nums2[k])
            {
                tempNum[i] = nums1[j];
                i++;
                j++;
            }
            else
            {
                tempNum[i] = nums2[k];
                i++;
                k++;
            }
        }

        //  add remaining elements from nums1[]
        while(j < nums1.length)
        {
            tempNum[i] = nums1[j];
            i++;
            j++;
        }

        //  add remaining elements from nums2[]
        while(k < nums2.length)
        {
            tempNum[i] = nums2[k];
            i++;
            k++;
        }

        // remember, 'index' starts from 0
        if(tempNum.length%2 != 0)
        {
            median = tempNum[tempNum.length/2];
        }
        else
        {
            median = (tempNum[(tempNum.length/2) - 1] + tempNum[(tempNum.length/2)]) / 2.0;
        }

        return median;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        // for inserting integer array
        System.out.print("Enter size of nums1: ");
        int arraySize1 = sc.nextInt();
        int[] nums1 = new int[arraySize1];
        System.out.print("Enter elements of nums1: ");
        for(int i=0; i<arraySize1; i++)
        {
            nums1[i] = sc.nextInt();
        }

        System.out.print("Enter size of nums2: ");
        int arraySize2 = sc.nextInt();
        int[] nums2 = new int[arraySize2];
        System.out.print("Enter elements of nums2: ");
        for(int i=0; i<arraySize2; i++)
        {
            nums2[i] = sc.nextInt();
        }

        double result = Solution(nums1, nums2);
        System.out.println("Result: " + result);

        sc.close();
    }
}
