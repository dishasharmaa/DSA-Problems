// 1) //implementing a queue using array

// public class QueueB {
//     static class Queue {
//         static int[] arr;
//         static int size;
//         static int rear;
        

//         Queue(int n) {
//             arr = new int[n];
//             size = n;
//             rear = -1;
//         }

//         public boolean isEmpty() {
//             return rear == -1;
//         }

//         // add ***** O(1)
//         public void add(int data) {
//             if (rear == size - 1) {
//                 System.out.println("Queue is full");
//                 return;
//             }
//             rear = rear + 1;
//             arr[rear] = data;
//         }

//         // remove ***** O(n)
//         public int remove() {
//             if (isEmpty()) {
//                 System.out.println("Queue is empty");
//                 return -1;
//             }
//             int front = arr[0];
//             for (int i = 0; i < rear; i++) {
//                 arr[i] = arr[i + 1];
//             }
//             rear = rear - 1;
//             return front;
//         }

//         // peek
//         public int peek() {
//             if (isEmpty()) {
//                 System.out.println("Queue is empty");
//                 return -1;
//             }
//             return arr[0];
//         }
//     }

//     public static void main(String[] args) {
//         Queue q = new Queue(5);
//         q.add(1);
//         q.add(2);
//         q.add(3);

//         while (!q.isEmpty()) {
//             System.out.println(q.remove());
//         }
//     }
// }

// 2) implementing a  circular queue using array

// public class QueueB {
//     static class Queue {
//         int[] arr;
//         int size;
//         int rear;
//         int front;

//         Queue(int n) {
//             arr = new int[n];
//             size = n;
//             rear = -1;
//             front = -1;
//         }

//         public boolean isEmpty() {
//             return rear == -1 && front == -1;
//         }

//         public boolean isFull() {
//             return (rear + 1) % size == front;
//         }

//         // add ***** O(1)
//         public void add(int data) {
//             if (isFull()) {
//                 System.out.println("Queue is full");
//                 return;
//             }
//             if (front == -1) {
//                 front = 0;
//             }
//             rear = (rear + 1) % size;
//             arr[rear] = data;
//         }

//         // remove ***** O(1)
//         public int remove() {
//             if (isEmpty()) {
//                 System.out.println("Queue is empty");
//                 return -1;
//             }

//             int result = arr[front];
//             if (rear == front) {    
//                 rear = front = -1;
//             } else {
//                 front = (front + 1) % size;
//             }
//             return result;
//         }

//         // peek ***** O(1)
//         public int peek() {
//             if (isEmpty()) {
//                 System.out.println("Queue is empty");
//                 return -1;
//             }
//             return arr[front];
//         }
//     }

//     public static void main(String[] args) {
//         Queue q = new Queue(5);
//         q.add(1);
//         q.add(2);
//         q.add(3);
//         System.out.println(q.remove());
//         q.add(4);
//         System.out.println(q.remove());
//         q.add(5);

//         while (!q.isEmpty()) {
//             System.out.println(q.remove());
//         }
//     }
// }


// 3) Implementing queue using linked list

// public class QueueB {
//     static class Node {
//         int data;
//         Node next;

//         Node(int data){
//             this.data = data;
//             this.next = null;
//         }
//     }
//     static class Queue {
//        static Node head = null;
//        static Node tail = null;
            
    
//             public boolean isEmpty() {
//                 return head == null && tail == null;
//             }
    
//             // add ***** O(1)
//             public void add(int data) {
//                 Node newNode = new Node(data);
//                 if(head == null){
//                     head = tail = newNode;
//                     return;
//                 }   
//                 tail.next = newNode;
//                 tail = newNode;
//             }
    
//             // remove ***** O(1)
//             public int remove() {
//                 if (isEmpty()) {
//                     System.out.println("Queue is empty");
//                     return -1;
//                 }
    
//                 int data = head.data;   
//                 // single element
//                 if (tail == head) {
//                     head = tail = null;
//                 } else {
//                     head = head.next;
//                 }
//                 return data;
//             }
    
//             // peek ***** O(1)
//             public int peek() {
//                 if (isEmpty()) {
//                     System.out.println("Queue is empty");
//                     return -1;
//                 }
//                 return head.data;
//             }
//         }
    
//         public static void main(String[] args) {
//             Queue q = new Queue();
//             q.add(1);
//             q.add(2);
//             q.add(3);
    
//             while (!q.isEmpty()) {
//                 System.out.println(q.peek());
//                 q.remove();
//             }
//         }
//     }

    // 4) implementing queue using java collection Framework ***** O(1)
    // queue can not make an object by itself because it is an interface

//     import java.util.*;
//     public class QueueB {
    
//     public static void main(String[] args) {
//         // Queue<Integer> q = new LinkedList<>(); //AraayDeque or Linked list
//         Queue<Integer> q = new ArrayDeque<>(); //AraayDeque or Linked list
//         // Queue q = new Queue();
//         q.add(1);
//         q.add(2);
//         q.add(3);

//         while (!q.isEmpty()) {
//             System.out.println(q.peek());
//             q.remove();
//         }
//     }
// }

// 5) Queue using 2 Stacks
// push O(n)

    // import java.util.*;
    // public class QueueB {
    //     static class Queue {
    //        static Stack<Integer> s1 = new Stack<>();
    //        static Stack<Integer> s2 = new Stack<>();

    //        public static boolean isEmpty(){
    //         return s1.isEmpty();
    //        }

    //     //    add
    //     public static void add(int x) {
    //         while(!s1.isEmpty()){
    //             s2.push(s1.pop());
    //         }
    //         s1.push(x);

    //         while(!s2.isEmpty()){
    //             s1.push(s2.pop());
    //         }
    //     }
    //     //    remove
    //     public static int remove() {
    //         if (isEmpty()) {
    //             System.out.println("Queue is empty");
    //             return 0;
    //         }
    //         return s1.pop();
    //     }
    //     // peek
    //     public static int peek() {
    //         if (isEmpty()) {
    //             System.out.println("Queue is empty");
    //             return 0;
    //         }
    //         return s1.peek();
    //     }
    // }
        
    //         public static void main(String[] args) {
    //             Queue q = new Queue();
    //             q.add(1);
    //             q.add(2);
    //             q.add(3);

    //             while(!q.isEmpty()){
    //                 System.out.println(q.peek());
    //                 q.remove();
    //             }   
    //     }
    // }

    // 6) Stack using 2 Queues
    //      pop P(n)

//     import java.util.LinkedList;
// import java.util.Queue;

// public class QueueB {
//     static class Stack {
//         Queue<Integer> q1 = new LinkedList<>();
//         Queue<Integer> q2 = new LinkedList<>();

//         public boolean isEmpty() {
//             return q1.isEmpty() && q2.isEmpty();
//         }

//         public void push(int data) {
//             // Add new element to q1
//             q1.add(data);
//         }

//         public int pop() {
//             if (isEmpty()) {
//                 System.out.println("Empty Stack");
//                 return -1;
//             }

//             // Move all elements except the last one from q1 to q2
//             while (q1.size() > 1) {
//                 q2.add(q1.remove());
//             }

//             // Remove and return the last element from q1
//             int top = q1.remove();

//             // Swap q1 and q2
//             Queue<Integer> temp = q1;
//             q1 = q2;
//             q2 = temp;

//             return top;
//         }

//         public int peek() {
//             if (isEmpty()) {
//                 System.out.println("Empty Stack");
//                 return -1;
//             }

//             int top = -1;

//             // Move all elements except the last one from q1 to q2
//             while (!q1.isEmpty()) {
//                 top = q1.remove();
//                 q2.add(top);
//             }

//             // Swap q1 and q2
//             Queue<Integer> temp = q1;
//             q1 = q2;
//             q2 = temp;

//             return top;
//         }
//     }

//     public static void main(String[] args) {
//         Stack s = new Stack();
//         s.push(1);
//         s.push(2);
//         s.push(3);

//         // Output elements in stack order
//         System.out.println(s.pop());
//         System.out.println(s.pop());
//         System.out.println(s.pop());
//     }
// }

// 7) First not-repeating letter in a stream of characters (Queue) ***** O(n)
// Given a stream of characters, write a function that prints the first non-repeating character in the
// stream. If there are no non-repeating characters, print -1.

// import java.util.*;

// public class QueueB {
//     public static void printNonRepeating(String str){
//         int freq[] = new int[26]; //'a'-'z'
//         Queue<Character> q = new LinkedList<>();
//         for(int i=0;i<str.length();i++){
//             char ch = str.charAt(i);
//             q.add(ch);
//             freq[ch-'a']++;

//             while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
//                 q.remove();
//             }
//             if(q.isEmpty()){
//                 System.out.print(-1+ " ");
//             } else {
//                 System.out.print(q.peek() + " ");
//             }
//         }
//         System.out.println();
//     }
//     public static void main(String[] args) {
//         String str = "aabccxb";
//         printNonRepeating(str);
//     }
// }

// 8) Interleave 2 halves of a Queue (even length) ***** O(n)
//      Given a queue of integers, interleave the elements of the queue in the following manner:
//      1. Take the first element of the queue and append it to the end of the queue
//      2. Take the second element of the queue and append it to the end of the queue
//      3. Repeat the process until all elements of the queue are interleaved.

// import java.util.*;

// public class QueueB {
//     public static void interleave(Queue<Integer> q) {
//         if (q.size() % 2 != 0) {
//             throw new IllegalArgumentException("Queue size should be even for interleaving.");
//         }

//         Queue<Integer> firstHalf = new LinkedList<Integer>();
//         int halfSize = q.size() / 2;

//         for (int i = 0; i < halfSize; i++) {
//             firstHalf.add(q.remove());
//         }

//         while (!firstHalf.isEmpty()) {
//             q.add(firstHalf.remove());
//             q.add(q.remove());
//         }
//     }

//     public static void main(String[] args) {
//         Queue<Integer> q = new LinkedList<Integer>();
//         q.add(1);
//         q.add(2);
//         q.add(3);
//         q.add(4);
//         q.add(5);
//         q.add(6);
//         q.add(7);
//         q.add(8);
//         q.add(9);
//         q.add(10);

//         interleave(q);

//         // print Q
//         while (!q.isEmpty()) {
//             System.out.print(q.remove() + " ");
//         }
//         System.out.println();
//     }
// }

// 9) Queue Reversal (Using stack) ***** O(n)

// import java.util.*;
// public class QueueB {
//     public static void reverse(Queue<Integer> q) {
//         Stack<Integer> s = new Stack<Integer>();

//         while (!q.isEmpty()) {
//             s.push(q.remove());
//         }
//         while (!s.isEmpty()) {
//             q.add(s.pop());
//         }
//     }
//     public static void main(String[] args) {
//         Queue<Integer> q = new LinkedList<Integer>();
//         q.add(1);
//         q.add(2);
//         q.add(3);
//         q.add(4);
//         q.add(5);

//         reverse(q);

//         // print Q
//         while (!q.isEmpty()) {
//             System.out.print(q.remove() + " "); 
//         }
//         System.out.println();
//     }
// }

// 10) Deque

// import java.util.*;

// public class QueueB {
//     public static void main(String[] args) {
//         Deque<Integer> deque = new LinkedList<Integer>();
//         deque.addFirst(1); // 1
//         deque.addFirst(2); // 2 1
//         deque.addFirst(3); // 3 2 1
//         deque.addLast(4);  // 3 2 1 4
//         System.out.println(deque);
//         deque.removeLast(); // Removes 4
//         System.out.println(deque);

//         System.out.println("first element = " + deque.getFirst()); // 3
//         System.out.println("last element = " + deque.getLast());  // 1
//     }
// }

// 11) Stack and Queue using Deque

import java.util.Deque;
import java.util.LinkedList;

public class QueueB {
    static class stack {
        Deque<Integer> deque = new LinkedList<Integer>();

        public void push(int data) {
            deque.addFirst(data);
        }

        public int pop() {
            return deque.removeFirst();
        }

        public int peek(){
            return deque.getFirst();
        }
    }

    // Stack and queue using deque

    static class Queue{
        Deque<Integer> deque = new LinkedList<>();

        public void add(int data){
            deque.addLast(data);
        }

        public int remove(){
            return deque.removeFirst();
        }
        public int peek(){
            return deque.getFirst();
        }
    }
    public static void main(String[] args) {
        // stack s = new stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // System.out.println("peek = "+ s.peek());
        // System.out.println("pop = "+ s.pop());
        // System.out.println("pop = "+ s.pop());
        // System.out.println("pop = "+ s.pop());

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("peek = "+ q.peek());
        System.out.println("remove = "+ q.remove());
        System.out.println("remove = "+ q.remove());
        System.out.println("remove = "+ q.remove());

    }
}

