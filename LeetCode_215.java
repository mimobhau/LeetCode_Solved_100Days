/* LeetCode_215>> Kth LARGEST ELEMENT in an ARRAY
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

    Example 1:

    Input: nums = [3,2,1,5,6,4], k = 2
    Output: 5

    Example 2:

    Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
    Output: 4

Constraints:
    1 <= k <= nums.length <= 105
    -104 <= nums[i] <= 104
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class LeetCode_215 {
    private static int Solution(int[] nums, int k)
    {
        /*  Approach 1: Using 'sorting', then returning the kth highest element
            Time Complexity: O(nlogn)

            NOT APPLICABLE, AS WE HAVE A BETTER APPROACH
         */

        /*  Approach 2: Using Priority Queue
            Time Complexity: O(n)
          
         * Priority Queue has three funcs - add(), remove() & peek()
         *      add() : adds elements sequentially {O(n)}
         *      remove() : removes the element with lowest priority, irrespective in what order the elements were inserted
         *      peek() : returns the lowest priority element
         

         * STEPS-
         
         * Step I - add the first 'k' elements in the Priority Queue
         * Step II - compare other elements with 'peak element' (lowest priority element in Priority Queue)
         * Step III - if, nums[i] > peak element; peak element is removed & nums[i] is inserted
         * Step IV - return the peak element -> ans 
        */

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++)
        {
            // Step I
            if(pq.size() < k)
                pq.add(nums[i]);
            // Step II
            else if(pq.peek() < nums[i])
            {
                // Step III
                pq.remove();
                pq.add(nums[i]);
            }
        }

        // Step IV
        return pq.peek();
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        // for inserting integer array
        System.out.print("Enter size of nums: ");
        int arraySize = sc.nextInt();
        int[] digits = new int[arraySize];
        System.out.print("Enter elements of nums: ");
        for(int i=0; i<arraySize; i++)
        {
            digits[i] = sc.nextInt();
        }

        System.out.print("k: ");
        int k = sc.nextInt();
    
        int result = Solution(digits, k);
        System.out.print("Result: " + result);
        sc.close();
    }
}
