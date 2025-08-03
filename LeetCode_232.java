/* LeetCode_232>> IMPLEMENT QUEUE USING STACKS
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

    void push(int x) Pushes element x to the back of the queue.
    int pop() Removes the element from the front of the queue and returns it.
    int peek() Returns the element at the front of the queue.
    boolean empty() Returns true if the queue is empty, false otherwise.

Notes:

    You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
    Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 

    Example 1:

    Input
    ["MyQueue", "push", "push", "peek", "pop", "empty"]
    [[], [1], [2], [], [], []]
    Output
    [null, null, null, 1, 1, false]

    Explanation
    MyQueue myQueue = new MyQueue();
    myQueue.push(1); // queue is: [1]
    myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
    myQueue.peek(); // return 1
    myQueue.pop(); // return 1, queue is [2]
    myQueue.empty(); // return false

Constraints:
    1 <= x <= 9
    At most 100 calls will be made to push, pop, peek, and empty.
    All the calls to pop and peek are valid.

Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
 */

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/*
 * to make a Queue, we need 2 Stacks - 'main' & 'helper'
 * while adding elements-
 * 
 * Step 1: moving elements from 'main' to 'helper'
 * Step 2: adding the element in the 'main' Stack
 * Step 3: moving the elements back from 'helper' to 'main'
 */

class MyQueue {
    // initialising the stacks
    private Stack<Integer> main;
    private Stack<Integer> helper;

    public MyQueue()
    {
        // providing them memory
        main = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x)
    {
        // Step 1: moving elements from 'main' to 'helper'
        while(main.size() > 0)
        {
            helper.push(main.pop());
        }

        // Step 2: adding the element in the 'main' queue
        main.push(x);

        // Step 3: moving the elements back from 'helper' to 'main'
        while(helper.size() > 0)
        {
            main.push(helper.pop());
        }
    }

    public int pop()
    {
        return main.pop();
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

public class LeetCode_232 {
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
    
        MyQueue myQueue = new MyQueue();

        sc.close();
    }
}
