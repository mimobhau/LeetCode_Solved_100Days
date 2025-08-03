/* LeetCode_225>> IMPLEMENT STACK USING QUEUES
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.

Notes:
    You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
    Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.

    Example 1:

    Input
    ["MyStack", "push", "push", "top", "pop", "empty"]
    [[], [1], [2], [], [], []]
    Output
    [null, null, null, 2, 2, false]

Explanation
    MyStack myStack = new MyStack();
    myStack.push(1);
    myStack.push(2);
    myStack.top(); // return 2
    myStack.pop(); // return 2
    myStack.empty(); // return False

Constraints:
    1 <= x <= 9
    At most 100 calls will be made to push, pop, top, and empty.
    All the calls to pop and top are valid.

Follow-up: Can you implement the stack using only one queue?
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * to make a Stack, we need 2 Queues - 'main' & 'helper'
 * while adding elements-
 
 * Step 1: moving elements from 'main' to 'helper'
 * Step 2: adding the element in the 'main' queue
 * Step 3: moving the elements back from 'helper' to 'main'
 */

class MyStack{
    // iniitialising the queues
    private Queue<Integer> main;
    private Queue<Integer> helper;

    public MyStack()
    {
        // providing them memory
        main = new LinkedList<>();
        helper = new LinkedList<>();
    }

    public void push(int x)
    {
        // Step 1: moving elements from 'main' to 'helper'
        while(main.size() > 0)
        {
            helper.add(main.remove());
        }

        // Step 2: adding the element in the 'main' queue
        main.add(x);

        // Step 3: moving the elements back from 'helper' to 'main'
        while(helper.size() > 0)
        {
            main.add(helper.remove());
        }
    }

    public int pop()
    {
        return main.remove();
    }

    public int top()
    {
        return main.peek();
    }

    public boolean empty()
    {
        if(main.size() > 0)
            return false;
        else
            return true;
    }
}

public class LeetCode_225 {
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
    
        MyStack myStack = new MyStack();
        
        sc.close();
    }
}
