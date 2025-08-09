/* LeetCode_58>> LENGTH of LAST WORD
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

    Example 1:

    Input: s = "Hello World"
    Output: 5
    Explanation: The last word is "World" with length 5.

    Example 2:

    Input: s = "   fly me   to   the moon  "
    Output: 4
    Explanation: The last word is "moon" with length 4.

    Example 3:

    Input: s = "luffy is still joyboy"
    Output: 6
    Explanation: The last word is "joyboy" with length 6.

Constraints:
    1 <= s.length <= 104
    s consists of only English letters and spaces ' '.
    There will be at least one word in s.
 */

import java.util.Scanner;

public class LeetCode_58 {
    private static int Solution(String s)
    {
        int count = 0;

        // since we need to find the length of the last word, we start from the end of the string
        for(int i=s.length()-1; i>=0; i++)
        {
            char ch = s.charAt(i);
            // ".charAt(i)" returns the character at index i in the string s

            if(ch != ' ')
                count++;
            // if we encounter a space after counting some characters, we break the loop
            // if we encounter a space after counting some chracters, last word has been completely iterated
            else if(count != 0)
                break;
        }

        return count;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();
    
        int result = Solution(s);
        System.out.print("Result: " + result);
        sc.close();
    }
}
