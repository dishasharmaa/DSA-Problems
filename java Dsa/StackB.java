// 1) Implementing Stacks using Array

// import java.util.ArrayList;

// public class StackB {
//         static class Stack{
//             static ArrayList<Integer> list = new ArrayList<>();

//             // isEmpty
//             public static boolean isEmpty() {
//                 return list.size() == 0;
//                 }
//             // push
//                 public static void push(int data) {
//                     list.add(data);
//                     }
//             // pop
//             public static int pop() {
//                 if (isEmpty()) {
//                     return -1;
//                 }
//                 int top = list.get(list.size() - 1);
//                 list.remove(list.size() - 1);
//                 return top;
//         }
//             // peek
//             public static int peek() {
//                 if (isEmpty()) {
//                     return -1;
//                 }
//             return list.get(list.size() - 1);
//             }
//             }
//     public static void main(String[] args) {
//         Stack s = new Stack();
//         s.push(1);
//         s.push(2);
//         s.push(3);

//         while(!s.isEmpty()){
//             System.out.println(s.peek());
//             s.pop();
//         }       
//     }
// }

// 2) implementing stack using linked list

// import java.util.ArrayList;

// public class StackB {
//     static class Node {
//         int data;
//         Node next;

//         Node(int data) {
//             this.data = data;
//             this.next = null;
//         }
//     }

//     public static class Stack {
//         static Node head = null; // Initialize head to null

//         public static boolean isEmpty() {
//             return head == null;
//         }

//         // push
//         public static void push(int data) {
//             Node newNode = new Node(data);

//             if (isEmpty()) {
//                 head = newNode; // Assign the new node to head
//             } else {
//                 newNode.next = head;
//                 head = newNode;
//             }
//         }

//         // pop
//         public static int pop() {
//             if (isEmpty()) {
//                 return -1; // Stack underflow
//             }
//             int top = head.data;
//             head = head.next;
//             return top;
//         }

//         // peek
//         public static int peek() {
//             if (isEmpty()) {
//                 return -1; // Stack is empty
//             }
//             return head.data;
//         }
//     }

//     public static void main(String[] args) {
//         Stack s = new Stack();
//         s.push(1);
//         s.push(2);
//         s.push(3);

//         while (!s.isEmpty()) {
//             System.out.println(s.peek());
//             s.pop();
//         }
//     }
// }

// 3) implementing stacks using java collection framework

// import java.util.*;

// public class StackB {

//     public static void main(String[] args) {
//         Stack<Integer> s = new Stack<>();
//                 // Stack s = new Stack();
//                 s.push(1);
//                 s.push(2);
//                 s.push(3);
        
//                 while (!s.isEmpty()) {
//                     System.out.println(s.peek());
//                     s.pop();
//                 }
//             }
//         }

// 4) Push ta the bottom of the stack

// import java.util.*;

// public class StackB {

//     public static void pushAtBottom(Stack<Integer> s, int data) {
//         if (s.isEmpty()) {
//             s.push(data);
//             return;
//         }
//         int top = s.pop();
//         pushAtBottom(s, data);
//         s.push(top);
//     }

//     public static void main(String[] args) {
//         Stack<Integer> s = new Stack<>();
//         s.push(1);
//         s.push(2);
//         s.push(3);

//         pushAtBottom(s, 4); // Push 4 at the bottom of the stack

//         while (!s.isEmpty()) {
//             System.out.println(s.pop()); // Print elements in LIFO order
//         }
//     }
// }

// 5) Reverse a String using a Stack

// import java.util.*;

// public class StackB {
//     public static String reverseString(String str) {
//         Stack<Character> s = new Stack<>();
//         int idx = 0;
//         while (idx < str.length()) {
//             s.push(str.charAt(idx));
//             idx++;
//         }

//         StringBuilder result = new StringBuilder("");
//         while (!s.isEmpty()) {
//             result.append(s.pop());
//         }
//         return result.toString();
//     }
//     public static void main(String[] args) {
//         String str = "HelloWorld";
//         String result = reverseString(str);
//         System.out.println(result);
//     }
// }

// 6) Reverse a Stack 

// import java.util.*;

// public class StackB {
//     public static void pushAtBottom(Stack<Integer> s, int data) {
//         if (s.isEmpty()) {
//             s.push(data);
//             return;
//         }
//         int top = s.pop();
//         pushAtBottom(s, data);
//         s.push(top);
//     }

//     public static void reverseStack(Stack<Integer> s) {
//         if (s.isEmpty()) {
//             return;
//         }
//         int top = s.pop();
//         reverseStack(s);
//         pushAtBottom(s, top);
//     }

//     public static void printStack(Stack<Integer> s) {
//         Stack<Integer> temp = new Stack<>();
//         while (!s.isEmpty()) {
//             int top = s.pop();
//             System.out.println(top);
//             temp.push(top);
//         }
//         while (!temp.isEmpty()) {
//             s.push(temp.pop());
//         }
//     }

//     public static void main(String[] args) {
//         Stack<Integer> s = new Stack<>();
//         s.push(1);
//         s.push(2);
//         s.push(3);
//         // Initial stack: 3, 2, 1
//         System.out.println("Original Stack:");
//         printStack(s);
        
//         reverseStack(s);
        
//         System.out.println("Reversed Stack:");
//         printStack(s);
//         // Reversed stack: 1, 2, 3
//     }
// }

// 7) Stock span Problem
//      Given an array of integers, calculate the stock span for all the elements. Stock span is defined
//      as the number of days a share price stays at the current price before there is a change in

// import java.util.*;

// import java.util.Stack;

// public class StackB {
//     public static void stockSpan(int stocks[], int span[]) {
//         Stack<Integer> s = new Stack<>();
//         s.push(0);
//         span[0] = 1;

//         for (int i = 1; i < stocks.length; i++) {
//             int currPrice = stocks[i];
//             while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
//                 s.pop();
//             }
//             if (s.isEmpty()) {
//                 span[i] = i + 1;
//             } else {
//                 int prevHigh = s.peek();
//                 span[i] = i - prevHigh;
//             }
//             s.push(i);
//         }
//     }

//     public static void main(String[] args) {
//         int stocks[] = {100, 80, 60, 70, 60, 85, 100};
//         int span[] = new int[stocks.length];
//         stockSpan(stocks, span);

//         for (int i = 0; i < span.length; i++) {
//             System.out.print(span[i] + " ");
//         }
//     }
// }

// 8) Next greater Element right ***** 0(n)
//      Given an array of integers, find the next greater element for each element. The next greater element
//      for an element x is the first greater element on the right side of x in array. Elements
//      are considered in left to right order.

// import java.util.*;

// public class StackB {
//     public static void main(String[] args) {
//         int arr[] = { 6, 8, 0, 1, 3 };
//         Stack<Integer> s = new Stack<>();
//         int nextGreater[] = new int[arr.length];

//         for(int i=arr.length-1; i>=0; i--){
//             // 1 while
//             while(!s.isEmpty() && arr[i] > arr[s.peek()]){
//                 s.pop();
//                 }
//                 // 2 if-else
//                 if(s.isEmpty()){
//                     nextGreater[i] = -1;
//                 }else{
//                 nextGreater[i] = arr[s.peek()];
//                 }

//                 // 3 push in stack
//                 s.push(i);
//                 }
//                 for(int i=0; i<arr.length; i++){
//                     System.out.print(nextGreater[i] + " ");
//                 }
//                 System.out.println();
//         }
//         }

// 9) Valid parentheses  ***** O(n)
//      Given a string containing just the characters '(', ')', '{', '}', '[' and '
//      ]', determine if the input string is valid.
//      An input string is valid if:
//      Open brackets must be closed by the same type of brackets.
//      Open brackets must be closed in the correct order.
//      Note that an empty string is also considered valid.

// import java.util.*;

// public class StackB {
//     public static boolean isValid(String str){
//         Stack<Character> s = new Stack<>();
//         for(int i=0; i<str.length(); i++){
//             char ch = str.charAt(i);

//             // opening
//             if(ch == '(' || ch == '{' || ch == '['){// opening
//                 s.push(ch);
//                 }else{
//                 // closing
//             if(s.isEmpty()){// empty stack
//                 return false;
//             }
//             if ( (s.peek() == '(' && ch == ')')
//             ||(s.peek() == '{' && ch == '}')
//             ||(s.peek() == '[' && ch == ']')){
//                 s.pop();
//                 }else{
//                     return false;
//                 }      
//             }
//         }
//         if(s.isEmpty()){
//             return true;
//             } else {
//                 return false;
//         }
//     }
//     public static void main(String[] args) {
//         String s = "({})[]"; //True
//         System.out.println(isValid(s));
//     }
// }

// 10) Duplicate Parentheses ***** O(n)
//      Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
//      determine if the input string is valid.
//      An input string is valid if:
//      Open brackets must be closed by the same type of brackets.
//      Open brackets must be closed in the correct order.
//      Note that an empty string is also considered valid.

// import java.util.*;
// public class StackB {

//     public static boolean isDuplicate(String str){
//         Stack<Character> s = new Stack<>();

//         for(int i=0; i<str.length(); i++){
//             char ch = str.charAt(i);
//             // closing
//             if(ch == ')'){
//                 int count = 0;
//                 while(s.peek() != '('){ 
//                     s.pop();
//                     count++;
//                 }
//                 if(count < 1){
//                     return true; //duplicate
//                 } else {
//                     s.pop(); //opening pair
//                 }
//             } else {
//                 // opening
//                 s.push(ch);
//             }
//         }
//         return false;
//     }
//     public static void main(String[] args) {
//         // Valid String
//         String str = "((a+b))"; //True
//         String str2 = "(a-b)"; //false
//         System.out.println(isDuplicate(str));
//     }
// }

// 11) Max Area in Histogram ***** O(n)
//      Given n non-negative integers representing the histogram's bar height where the width of each bar is
//      1, find the area of largest rectangle in the histogram.

import java.util.*;

public class StackB {
    public static int maxArea(int arr[]) {
        int maxArean = 0;
        int nsr[] = new int[arr.length]; // next smaller right
        int nsl[] = new int[arr.length]; // next smaller left

        // Next smaller right
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // Next smaller left
        s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // Calculate the maximum area
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArean = Math.max(currArea, maxArean);
        }

        return maxArean;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 2, 3}; // heights in histogram
        System.out.println("Max area of histogram = " + maxArea(arr));
    }
}


