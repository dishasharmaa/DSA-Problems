// import java.util.ArrayList;

// public class Classroom {
// //     public static int storeWater(ArrayList<Integer> height) {
// //         int maxWater = 0;
// //         //brute force ***** O(n^2)
// //         for(int i=0; i<height.size(); i++) {
// //             for(int j=i+1; j<height.size(); j++) {
// //                 int ht = Math.min(height.get(i), height.get(j));
// //                 int width = j-i;
// //                 int currWater = ht * width;
// //                 maxWater = Math.max(maxWater, currWater);
// //         }
// //     }
// //     return maxWater;
// // }

// // Two pointer approach ***** O(n)

// public static int storeWater(ArrayList<Integer> height) {
//     int maxWater = 0;
//     int lp = 0;
//     int rp = height.size()-1;

//     while(lp < rp) {
//         // calculate water area
//         int ht = Math.min(height.get(lp), height.get(rp));
//         int width = rp-lp;
//         int currWater = ht*width;
//         maxWater = Math.max(maxWater, currWater);

//         // update ptr
//         if(height.get(lp) < height.get(rp)) {
//             lp++;
//     } else {
//         rp--;
//     }
// }
// return maxWater;
// }
//     public static void main(String[] args) {
//         ArrayList<Integer> height = new ArrayList<>();
//         //1, 8, 6, 2, 5, 4, 8, 3, 7
//         height.add(1);
//         height.add(8);
//         height.add(6);
//         height.add(2);
//         height.add(5);
//         height.add(4);
//         height.add(8);
//         height.add(3);
//         height.add(7);

//         System.out.println(storeWater(height));
        
//     }
// }

// Pair Sum 1
//  Find if any pair in a sorted ArrayList has a target sum

// import java.util.ArrayList;

// public class Classroom {
    // brute force
    // public static boolean pairSum1(ArrayList<Integer> list, int target) {
    //     for (int i = 0; i < list.size(); i++) {
    //         for (int j = i + 1; j < list.size(); j++) {
    //             if (list.get(i) + list.get(j) == target) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // 2 pointer approach
//     public static boolean pairSum1(ArrayList<Integer> list, int target) {
//         int lp = 0;
//         int rp = list.size() - 1;

//         while(lp != rp) {
//             // case 1
//             if (list.get(lp) + list.get(rp) == target) {
//                 return true;
//         }
//         // case 2
//         else if (list.get(lp) + list.get(rp) < target) {
//             lp++;
//             } else {
//                 // case 3
//                 rp--;
//             }
//             }
//             return false;
//     }


//     public static void main(String[] args) {
//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(1);
//         list.add(2);
//         list.add(3);
//         list.add(4);
//         list.add(5);
//         list.add(6);
        
//         int target = 5;
//         System.out.println(pairSum1(list, target));
//     }
// }

// Pair Sum 2
// Find if any pair in a sorted and rotated ArrayList has a target sum

// 2 Pointer Approach ***** O(n)

import java.util.ArrayList;

public class Classroom {

    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int bp = -1;
        int n = list.size();
        
        // Finding the breaking point (rotation point)
        for(int i = 0; i < list.size(); i++) {
            if(i < list.size() - 1 && list.get(i) > list.get(i + 1)) { // Check if current element is greater than the next
                bp = i + 1; // bp is the index of the smallest element
                break;
            }
        }
        
        int lp = bp % n; // Smallest element pointer
        int rp = (bp - 1 + n) % n; // Largest element pointer
        
        while(lp != rp) {
            int sum = list.get(lp) + list.get(rp);
            
            if(sum == target) {
                return true;
            } else if(sum < target) {
                lp = (lp + 1) % n; // Move lp to the right
            } else {
                rp = (rp - 1 + n) % n; // Move rp to the left
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(); 
        // 11, 15, 6, 8, 9, 10 - Sorted and rotated
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        System.out.println(pairSum2(list, target));
    }
}

