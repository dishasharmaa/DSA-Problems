// import java.util.LinkedList;

// public class Frameworks {
//     public static void main(String[] args) {
//         // Basic LinkedList operations using Java's built-in LinkedList
//         LinkedList<Integer> ll = new LinkedList<>();
        
//         // Adding elements
//         ll.addLast(1);
//         ll.addLast(2);
//         ll.addFirst(0);
//         // 0 -> 1 -> 2
//         System.out.println("Initial LinkedList: " + ll);
        
//         // Removing elements
//         ll.removeFirst();
//         ll.removeLast();
//         System.out.println("After removing first and last elements: " + ll);
//     }
// }

import java.util.*;
import java.util.LinkedList;

public class Frameworks {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid node
    }

    private Node merge(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node temp = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return dummy.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle node
        Node mid = getMid(head);

        // Divide the list into left and right halves
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Merge the sorted halves
        return merge(newLeft, newRight);
    }

    public static void main(String[] args) {
        mergeSortLL customLL = new mergeSortLL();
        customLL.addFirst(1);
        customLL.addFirst(2);
        customLL.addFirst(3);
        customLL.addFirst(4);
        customLL.addFirst(5);
        // 5 -> 4 -> 3 -> 2 -> 1
        
        System.out.println("Custom LinkedList before sorting:");
        customLL.print();
        
        customLL.head = customLL.mergeSort(customLL.head);
        
        System.out.println("Custom LinkedList after sorting:");
        customLL.print();
    }
}
