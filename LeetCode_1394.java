/* LeetCode_1394>> FIND LUCKY INTEGER in an ARRAY
Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.

Return the largest lucky integer in the array. If there is no lucky integer return -1.

    Example 1:

    Input: arr = [2,2,3,4]
    Output: 2
    Explanation: The only lucky number in the array is 2 because frequency[2] == 2.

    Example 2:

    Input: arr = [1,2,2,3,3,3]
    Output: 3
    Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.

    Example 3:

    Input: arr = [2,2,2,3,3]
    Output: -1
    Explanation: There are no lucky numbers in the array.

Constraints:
    1 <= arr.length <= 500
    1 <= arr[i] <= 500
 */

import java.util.HashMap;
import java.util.Scanner;

public class LeetCode_1394 {
    private static int Solution(int[] nums)
    {
        // Initialising a Hash Map
        HashMap<Integer, Integer> hm = new HashMap<>();
        /*
         * a Hash Map is used to store key-value pairs
         * here, we store the different values and their frequency
         */

        for(int i=0; i<nums.length; i++)
        {
            int element = nums[i];

            // if the HashMap already contains the key, its frequency is increased++
            if(hm.containsKey(element) == true)
                hm.put(element, hm.get(element) + 1);
            // if the key doesn't exist, the element(key) is put in the HashMap with frequency=1
            else
                hm.put(element, 1);
        }
            
        int ans = -1;

        // forEach loop
        // "keySet()" fetches all the unique values from the HashMap table
        for(int key: hm.keySet())
        {
            // checks if element == frequency
            if(hm.get(key) == key)
                ans = Math.max(ans, key);
                // sets the max 'lucky' element
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
        
        int result = Solution(nums);
        System.out.print("Result: " + result);

        sc.close();
    }
}
