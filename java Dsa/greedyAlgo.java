// 1) Activity Selection
// Given a set of activities, find the maximum number of activities that can be performed by a single
// person, assuming that a person can only work on a single activity at a time.
// 

// import java.util.*; // ***** O(n log n)

// public class greedyAlgo {
//     public static void main(String[] args) {
//         int start[] = {1, 3, 0, 5, 8, 5};
//         int end[] = {2, 4, 6, 7, 9, 9};

//         // Step 1: Create an array to store activities with their indices
//         int activities[][] = new int[start.length][3];
//         for (int i = 0; i < start.length; i++) {
//             activities[i][0] = i;      // Store original index of activity
//             activities[i][1] = start[i];
//             activities[i][2] = end[i];
//         }

//         // Step 2: Sort activities based on their end times
//         Arrays.sort(activities, Comparator.comparingInt(a -> a[2]));

//         // Step 3: Apply greedy algorithm to select maximum number of activities
//         int maxAct = 0;
//         ArrayList<Integer> selectedActivities = new ArrayList<>();
        
//         // Select the first activity
//         maxAct++;
//         selectedActivities.add(activities[0][0]);
//         int lastEnd = activities[0][2];

//         // Iterate through sorted activities and select non-overlapping activities
//         for (int i = 1; i < activities.length; i++) {
//             if (activities[i][1] >= lastEnd) {
//                 maxAct++;
//                 selectedActivities.add(activities[i][0]);
//                 lastEnd = activities[i][2];
//             }
//         }

//         // Output the results
//         System.out.println("Max activities = " + maxAct);
//         System.out.print("Activities selected: ");
//         for (int i : selectedActivities) {
//             System.out.print("A" + i + " ");
//         }
//         System.out.println();
//     }
// }

// 2) Fractional Knapsack
// Given the weight and values of N values, put these items in a knapsack of
// capacity W to get the maximum total value in the knapsack.
// value = [60, 100, 120]
// weight = [10, 20, 30]
// W = 50
// Output: 220 (Put item 1 with value 100 and weight 20, item

// import java.util.*;
// public class greedyAlgo{

//     public static void main(String[] args) {
//         int val[] = {60, 100, 120};
//         int weight[] = {10, 20, 30};
//         int W = 50;

//         double ratio[][] = new double[val.length][2];
//         // 0th col => idx ; 1st col => ratio

//         for (int i = 0; i < val.length; i++) {
//             ratio[i][0] = i;
//             ratio[i][1] = val[i]/(double)weight[i];
//         }
//         // ascending order
//         Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

//         int capacity = W;
//         int finalVal = 0;
//         for(int i=ratio.length-1; i>=0; i-- ){
//             int idx = (int)ratio[i][0];
//             if(capacity >= weight[idx]){ //include full item
//                 finalVal += val[idx];
//                 capacity -= weight[idx];
//             } else {
//                 // include fractional item
//                 finalVal += (ratio[i][1] * capacity);
//                 capacity = 0;
//                 break;
//             }
//         }
//         System.out.println("final value = "+ finalVal);
//     }
// }

// 3) Min Absolute difference Pairs
// given two arrays A and B of equal length n. pair each element of array A to an element
// of array B such that the absolute difference between the pair is minimum. Return the minimum absolute difference.

// import java.util.*;
// public class greedyAlgo{
//     public static void main(String[] args) {
//         int A[]= {4,1,8,7};
//         int B[]= {2,3,6,5};

//         Arrays.sort(A);
//         Arrays.sort(B);

//         int minDiff = 0;

//         for(int i=0; i<A.length; i++){
//             minDiff += Math.abs(A[i]-B[i]);
//         }
//         System.out.println("Minimum absolute difference of pairs =" + minDiff);
//     } 
// }

// 4) Max length Chain of Pairs
// you are given n pairs of numbers, in every pair, the first number is always smaller than the
// second number. A pair (c, d) can follow another pair (a, b) if b<c.
// Write a program to find the length of the longest possible chain from a given array of pairs.

// import java.util.*;
// public class greedyAlgo{ //O(nlogn)
//     public static void main(String[] args) {
//         int pairs[][] = {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}};

//         Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

//         int chainLen = 1;
//         int chainEnd = pairs[0][1]; //last selected pair end //chain end

//         for(int i=1; i<pairs.length; i++){
//             if(pairs[i][0] > chainEnd){
//                 chainLen++;
//                 chainEnd = pairs[i][1];
//             }
//         }
//         System.out.println("Longest chain length = " + chainLen);
//     }
// }

// 5) Indian Coins
// we are given an infinite supply of denominations
// of 1, 2, 5, 10, 20, 50, 100, 500, 2000,
// we need to find the total number of ways to make a change for a given value

// import java .util.*;
// public class greedyAlgo{
//     public static void main(String[] args) {
//         Integer coins[] = {1,2,5,10,20,50,100,500,2000};

//         Arrays.sort (coins, Comparator.reverseOrder());
//         // 2000, 500, 100, 50, 20, 10

//         int countOfCoins = 0;
//         int amount = 1050;
//         ArrayList<Integer> ans = new ArrayList<>();

//         for(int i=0; i<coins.length; i++){
//             if(amount >= coins[i]){
//                 while(coins[i] <= amount){
//                     countOfCoins++;
//                     amount -= coins[i];
//                     ans.add(coins[i]);
//                 }
//             }
//         }
//         System.out.println("Total number of coins = " + countOfCoins);

//         for(int i=0; i<ans.size(); i++){
//             System.out.println(ans.get(i) + " ");
//         }
//         System.out.println();
//     }
// }

// 6) Job Sequencing Problem
// Given a set of jobs with their deadlines and has a deadline and profit if the job is finished
// before the deadline. It is also given that every job takes a single unit of time, so the
// minimum possible deadline for any job is . Maximum the total profit
// if only one job can be scheduler at a time.

// import java.util.*;

// public class greedyAlgo {
//     static class Job {
//         int id;
//         int profit;
//         int deadline;

//         public Job(int i, int d, int p) {
//             id = i;
//             deadline = d;
//             profit = p;
//         }
//     }

//     public static void main(String[] args) {
//         int jobsInfo[][] = { {4, 20}, {1, 10}, {1, 40}, {1, 30} };

//         ArrayList<Job> jobs = new ArrayList<>();

//         for (int i = 0; i < jobsInfo.length; i++) {
//             jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
//         }

//         Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit); // descending order of profit

//         ArrayList<Integer> seq = new ArrayList<>();
//         int time = 0;
//         for (int i = 0; i < jobs.size(); i++) {
//             Job curr = jobs.get(i);
//             if (curr.deadline > time) {
//                 seq.add(curr.id);
//                 time++;
//             }
//         }

//         // print seq
//         System.out.println("max jobs = " + seq.size());
//         for (int i = 0; i < seq.size(); i++) {
//             System.out.print(seq.get(i) + " ");
//         }
//         System.out.println();
//     }
// }

// Chocola Problem

import java.util.*;

public class greedyAlgo {
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costVer[] = {2, 1, 3, 1, 4}; // m-1
        Integer costHor[] = {4, 1, 2}; // n-1

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1; // start with 1 piece horizontally and vertically
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costHor[h] <= costVer[v]) { // vertical cut
                cost += costVer[v] * hp;
                vp++;
                v++;
            } else { // horizontal cut
                cost += costHor[h] * vp;
                hp++;
                h++;
            }
        }

        while (h < costHor.length) {
            cost += costHor[h] * vp;
            hp++;
            h++;
        }

        while (v < costVer.length) {
            cost += costVer[v] * hp;
            vp++;
            v++;
        }

        System.out.println("The cost of cuts = " + cost);
    }
}
