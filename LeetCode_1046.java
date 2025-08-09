/* LeetCode_1046>> LAST STONE WEIGHT
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.

    Example 1:

    Input: stones = [2,7,4,1,8,1]
    Output: 1
    Explanation: 
    We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
    we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
    we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
    we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.

    Example 2:

    Input: stones = [1]
    Output: 1

Constraints:
    1 <= stones.length <= 30
    1 <= stones[i] <= 1000
 */

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LeetCode_1046 {
    private static int Solution(int[] stones)
    {
        /*
         APPROACH-1: Using Sorting (after every smash, we need to sort the array)
         * Time Complexity: (n * nlogn) [ n - number of times we need to sort the array; nlogn - time complexity of sorting]
         
         APPROACH-2: Using Priority Queue (max heap)
         * [max heap - gives the largest element the highest priority; ".remove()" returns the largest element] 
         * Time Complexity: O(nlogn) [n - number of elements; logn - time complexity to remove the largest element]
         
         Steps-
         * Step 1: Create a max-heap Priority Queue, and insert the element
         * Step 2: remove the two largest elements, perform 'smash', and insert the result (if, result != 0)
         * Step 3: return the last element
         */

        if(stones.length == 1)
            return stones[0];

        // max priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        /* "Collections.reverseOrder()"
         * This is a comparator that reverses the natural ordering.
         * For Integer, the natural order is ascending.
         * Reversing it makes it descending order
         */

        // forEach loop
        for(int element: stones)
        {
            pq.add(element);        // Step 1
        }

        // Step 2
        while(pq.size() > 1)
        {
            // ".remove()" - removes the largest element
            int max = pq.remove();
            int smax = pq.remove();

            int result = max - smax;

            if(result != 0)
                pq.add(result);
        }
        
        if(pq.size() == 0)
            return 0;
        else
            return pq.remove();
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
    
        int result = Solution(digits);
        System.out.print("Result: " + result);
        sc.close();
    }
}
