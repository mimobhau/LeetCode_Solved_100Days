/* LeetCode_443>> STRING COMPRESSION
Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.

    Example 1:

    Input: chars = ["a","a","b","b","c","c","c"]
    Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
    Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

    Example 2:

    Input: chars = ["a"]
    Output: Return 1, and the first character of the input array should be: ["a"]
    Explanation: The only group is "a", which remains uncompressed since it's a single character.

    Example 3:

    Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
    Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
    Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".

Constraints:
    1 <= chars.length <= 2000
    chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
 */

import java.util.Scanner;

public class LeetCode_443 {
    private static int Solution(char[] nums)
    {
        int count = 0;
        // StringBuilder is used so it can be modified/mutated easily
        StringBuilder sb = new StringBuilder();
        // adding the first character
        sb.append(nums[0]);

        for(int i=1; i<nums.length; i++)
        {
            // if the current and previous characters are not same & count>1; append count
            if(nums[i-1] == nums[i])
            {
                if(count > 1)
                    sb.append(count+"");
                    
                // the current chracter (which is not same as previous) is appended to StringBuilder, & count=1 (for the new character)
                sb.append(nums[i]);
                count = 1;
            }
            // if the current and previous characters are same; count++
            else
                count++;
        }

        // for appending the count of the last character (as the loop ends before appending it)
        if(count > 1)
            sb.append(count+"");

        // since we are asked to return the ans in the original array
        for(int i=0; i<sb.length(); i++)
        {
            char ch = sb.charAt(i);
            nums[i] = ch;
        }

        return sb.length();
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        // for inserting integer array
        System.out.print("Enter size of nums: ");
        int arraySize = sc.nextInt();
        char[] nums = new char[arraySize];
        System.out.print("Enter elements of nums: ");
        for(int i=0; i<arraySize; i++)
        {
            nums[i] = sc.nextChar();
        }
    
        int result = Solution(nums);
        System.out.println("Result: " + result);
        sc.close();
    }
}
