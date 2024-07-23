public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public static Node head;
    public static Node tail;
    public static int size; // Added size variable

    // To add a node at the first position
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // To add a node at the last position
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // To print the linked list
    public void print() { // O(n)
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // To add a new node at a particular index
    public void add(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        for(int i = 0; i < idx - 1; i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // To remove the element from the first place
    public int removeFirst(){
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // To remove a node from the last place
    public int removeLast(){
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for(int i = 0; i < size - 2; i++){
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // Search (iterative)
    // search for a key in a linked list. return the position where it is found . if bot found return -1

    public int itrSearch(int key){ //*****O(n)
        Node temp = head;
        int i = 0;

        while(temp != null){
            if(temp.data == key){ //key found
                return i;
            }
            temp = temp.next;
            i++;
        }
        //key not found
        return -1;
    }

        // Search (Recursive)
    // search for a key in a linked list. return the position where it is found . if bot found return -1 (Use Recursion)
    
    public int helper(Node head, int key){
        if(head == null){ //base case
            return -1;
            }
            if(head.data == key){ //key found
                return 0;
                }
                int idx = helper(head.next, key); //key not found
                if(idx == -1){ //key not found
                    return -1;
                    }
               return idx+1;     

    }

    public int recSearch(int key){ //*****O(n)
        return helper(head, key);
        }

        // Reverse a linked list (Iterative approach) importanttt

        public void reverse(){
            Node prev = null;
            Node curr = tail = head;
            Node next;

            while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;    
            }
            head = prev;
        }

        // Find and remove Nth node from End (Iterative Approach)

        public void deleteNthFromEnd(int n){
            // calculate sz = 0;
            int sz = 0;
            Node temp = head;
            while(temp != null){
                temp = temp.next;
                sz++;
                }
            if(n == sz){
                head = head.next; //remove first
                return;
            }    

            // sz - n
            int i = 1;
            int iToFind = sz-n;
            Node prev = head;
            while(i < iToFind){
                prev = prev.next;
                i++;
            }
            prev.next = prev.next.next;
            return;
        }

        // Check if a linked list is a palindrome

        // slow fast approach to find the middle node
        public Node findMid(Node head){ //helper
            Node slow = head;
            Node fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next; //+1
                fast = fast.next.next; //+2
            }
            return slow; //Slow is the middle
        }

        public boolean checkPalindrome(){
            if(head == null || head.next == null){
                return true;
            }
            // Step 1 - find mid
            Node midNode = findMid(head);

            // Step 2 - reverse 2nd half
            Node prev = null;
            Node curr = midNode;
            Node next;

            while(curr !=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            Node right = prev;//right half head
            Node left = head;//left half head

            // sStep 3 - check left half and right half
            while(right != null){
                if(left.data != right.data){
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            return true;
        }

        // ll part 2

        // Detecting cycle code
        public static boolean isCycle(){ //Floy's cycle finding algorithm
            Node slow = head;
            Node fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next; //+1
                fast = fast.next.next; //+2
                if(slow == fast){
                    return true; //cycle exists
                }
            }
            return false; //cycle does not exist
        }

        // Remove a loop/ cycle in a linked list

        public static void removeCycle(){ //Floy's cycle finding algorithm
        // Step1 - detect cycle
        Node slow = head;   
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }


        // Step 2 -finf meeting point
        slow = head;
        Node prev = null; //last node
        while(slow != fast){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            }

        // Step 3 - remove cycle -> last.next = null
        prev.next = null;
            }

    // public static void main(String[] args) {
    //     linkedList ll = new linkedList();
    //     ll.addFirst(2);
    //     ll.addFirst(1);
    //     ll.addLast(4);
    //     ll.addLast(5);
    //     ll.add(2, 3);

    //     ll.print();
    //     // ll.removeFirst();
    //     // ll.print();
    //     // ll.removeLast();
    //     // ll.print();
    //     // System.out.println("Size of linked list: " + ll.size);

    //     // System.out.println(ll.itrSearch(3));
    //     // System.out.println(ll.itrSearch(10));

    //     // System.out.println(ll.recSearch(3));
    //     // System.out.println(ll.recSearch(10));

    //     // ll.reverse();
    //     // ll.print();

    //     // ll.deleteNthFromEnd(3);
    //     ll.print();
    //     System.out.println(ll.checkPalindrome());


    

    

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; //mid node
    }

    private Node merge(Node head1, Node head2){
        Node dummy = new Node(0);
        Node temp = dummy;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;    
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
            }
            return dummy.next;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        // Find Node
        Node mid = getMid(head);

        // Left and right Merge sort
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Merge
        return merge(newLeft, newRight);
    }

    // Zig Zag linked list
    public void zigZag(){
        // find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // alt merge = zig zag merge
        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        // 1-> 2-> 3->4->5

        // ll.print();
        // ll.head = ll.mergeSort(ll.head);
        // ll.print();

        ll.print();
        ll.zigZag();
        ll.print();


    }
}

    // public static void main(String[] args) {
    //     head = new Node(1);
    //     Node temp = new Node(2);
    //     head.next = new Node(2);
    //     head.next = temp;
    //     head.next.next = new Node(3);
    //     head.next.next.next = temp;
    //     // 1 -> 2 -> 3 -> 2
    //     System.out.println(isCycle());
    //     removeCycle();
    //     System.out.println(isCycle());
    // }
    // }
