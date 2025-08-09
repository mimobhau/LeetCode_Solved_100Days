/* LeetCode_128>> LONGEST CONSECUTIVE SEQUENCE
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

    Example 1:

    Input: nums = [100,4,200,1,3,2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

    Example 2:

    Input: nums = [0,3,7,2,5,8,4,6,0,1]
    Output: 9

    Example 3:

    Input: nums = [1,0,1,2]
    Output: 3

Constraints:
    0 <= nums.length <= 105
    -109 <= nums[i] <= 109
*/

import java.util.HashMap;
import java.util.Scanner;

public class LeetCode_128 {
    private static int Solution(int[] nums)
    {
        // creating a HashMap that stores all the numbers in the 'nums[]' array, with the initial value 'false'
        HashMap<Integer, Boolean> hm = new HashMap<>();

        // inserting the numbers in the HashMap
        for(int i=0; i<nums.length; i++)
        {
            hm.put(nums[i], false);
        }

        // checks for each number if it is the start of a consecutive sequence; by checking if there its previous numbers exists
        // if it does not exist, then it is the start of a consecutive sequence (set to 'true')
        for(int key: hm.keySet())
        {
            if(hm.containsKey(key-1) == false)
                hm.put(key, true);
        }

        // max length of consecutive sequence
        int max = 0;

        /*
         * '.keySet()' --> returns a set view of the keys contained in this map.
         * '.containsKey()' -->  method checks if the specified key is present in the map.
         * '.get()' --> returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
         */

        for(int key: hm.keySet())
        {
            int k=1;
            // checks if the current number is the start of a consecutive sequence (true)
            if(hm.get(key) == true)
            {
                // if it is, then it checks for the next consecutive numbers (increments 'max')
                while(hm.containsKey(key+k) == true)
                {
                    k++;
                }
            }
            // checks which sequence is the longest
            max = Math.max(max, k);
        }

        return max;
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
