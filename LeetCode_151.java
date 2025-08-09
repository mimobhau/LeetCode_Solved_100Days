/* LeetCode_151>> REVERSE WORDS in a STRING
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

    Example 1:

    Input: s = "the sky is blue"
    Output: "blue is sky the"

    Example 2:

    Input: s = "  hello world  "
    Output: "world hello"
    Explanation: Your reversed string should not contain leading or trailing spaces.

    Example 3:

    Input: s = "a good   example"
    Output: "example good a"
    Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

Constraints:
    1 <= s.length <= 104
    s contains English letters (upper-case and lower-case), digits, and spaces ' '.
    There is at least one word in s.

Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */

import java.util.Scanner;

public class LeetCode_151 {
    private static String Solution(String s)
    {
        // we will be using '.split()' method to split the string into words, the words will be stored as elements of an array
        // '.trim()' is used to remove leading and trailing spaces
        String[] arr = s.trim().split("\\s+");     //splits on the basis of one/multiple spaces

        // StringBuilder to store the result, as it is mutable and efficient for string concatenation, unlike String
        StringBuilder sb = new StringBuilder("");       // as the result returned will be a string only

        // we will iterate through the array in reverse order and append each word to the StringBuilder
        for(int i=arr.length-1; i>=0; i++)
        {
            sb.append(arr[i]);
            if(i != 0)
                sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        // for inserting integer array
        System.out.print("Enter string: ");
        String s = sc.nextLine();
    
        String result = Solution(s);
        System.out.print("Result: " + result);
        sc.close();
    }
}
