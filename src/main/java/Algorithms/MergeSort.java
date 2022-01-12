package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MergeSort {

    public static ArrayList<Integer> sort(ArrayList<Integer> unsortedList) {
        if(unsortedList.size() <= 1)
            return unsortedList;
        int left = 0;
        int right = unsortedList.size()-1;
        int middle = (left + right)/2;
        return divide(unsortedList, left, middle, right);
    }

    private static ArrayList<Integer> divide(ArrayList<Integer> list, int left, int middle, int right) {
       if(left < right) {
           int firstHalfLeft = left;
           int firstHalfRight = middle;
           int firstHalfMiddle = (firstHalfLeft + firstHalfRight)/2;
           if(firstHalfLeft < firstHalfRight)
               divide(list, firstHalfLeft, firstHalfMiddle, firstHalfRight);
           int secondHalfLeft = middle+1;
           int secondHalfRight = right;
           int secondHalfMiddle = (secondHalfLeft + secondHalfRight)/2;
           if(secondHalfLeft < secondHalfRight)
               divide(list, secondHalfLeft, secondHalfMiddle, secondHalfRight);
       }
       return inPlaceMerge(list, left, middle, right);
    }

    private static ArrayList<Integer> inPlaceMerge(ArrayList<Integer> list, int left, int middle, int right) {
        Queue<Integer> mergeRegister = new LinkedList<>();
        int firstPointer = left;
        int secondPointer = middle +1;
        while(firstPointer < secondPointer && secondPointer <= right+1) {
            if ( secondPointer > right) {
                if (mergeRegister.isEmpty()) {
                    secondPointer++;
                    continue;
                } else if (!mergeRegister.isEmpty()) {
                    if(list.get(firstPointer) != null)
                        mergeRegister.add(list.get(firstPointer));
                    list.set(firstPointer, mergeRegister.poll());
                    firstPointer++;
                }
            } else if (!mergeRegister.isEmpty()) {
                if(mergeRegister.peek() <= list.get(secondPointer)) {
                    mergeRegister.add(list.get(firstPointer));
                    list.set(firstPointer, mergeRegister.poll());
                    firstPointer++;
                } else {
                    if(list.get(firstPointer) != null)
                        mergeRegister.add(list.get(firstPointer));
                    list.set(firstPointer, list.get(secondPointer));
                    list.set(secondPointer, null);
                    firstPointer++;
                    secondPointer++;
                }
            } else if (mergeRegister.isEmpty()) {
                if (list.get(firstPointer) <= list.get(secondPointer)) {
                    firstPointer++;
                } else {
                    if(list.get(firstPointer) != null)
                        mergeRegister.add(list.get(firstPointer));
                    list.set(firstPointer, list.get(secondPointer));
                    list.set(secondPointer, null);
                    firstPointer++;
                    secondPointer++;
                }
            }
        }

        return list;
    }
}
